local BIN = "DATA";
local function trim(s)
    return (s:gsub("^%s*(.-)%s*$", "%1"))
end
local function min(a, b)
    if a <= b then
        return a
    else
        return b
    end
end

local function strLen(str)
    local lenInByte = #str
    local charCount = 0
    local i = 1
    while (i <= lenInByte)
    do
        local curByte = string.byte(str, i)
        local byteCount = 1;
        if curByte > 0 and curByte <= 127 then
            byteCount = 1                                               --1字节字符
        elseif curByte >= 192 and curByte < 223 then
            byteCount = 2                                               --双字节字符
        elseif curByte >= 224 and curByte < 239 then
            byteCount = 3                                               --汉字
        elseif curByte >= 240 and curByte <= 247 then
            byteCount = 4                                               --4字节字符
        end

        --local char = string.sub(str, i, i + byteCount - 1)
        i = i + byteCount                                               -- 重置下一字节的索引
        charCount = charCount + 1                                       -- 字符的个数（长度）
    end
    return charCount
end

local function isEmpty(s)
    return s == nil or #s == 0;
end

local function findLast(s, toFind)
    local i = s:match(".*" .. toFind .. "()")
    if i == nil then
        return nil
    else
        return i - 1
    end
end
local function array2Str(array)
    local s = "";
    for i = 1, #array do
        s = s .. array[i] .. ";";
    end
    return s
end

local function seg(str)
    local array = {}
    local firstIndex = string.find(str, "_");--%转义
    if firstIndex == nil then
        firstIndex = strLen(str) + 1
    end
    local lastIndex = findLast(str, "_");
    if lastIndex == nil then
        lastIndex = strLen(str)
    end

    array[1] = string.sub(str, 1, firstIndex - 1)
    array[2] = string.sub(str, firstIndex + 1, lastIndex - 1)
    array[3] = string.sub(str, lastIndex + 1)
    return array;
end

local function getLevenshteinDistance(s, t)
    if s and t then
        local n = strLen(s)
        local m = strLen(t)
        if n == 0 then
            return m
        elseif m == 0 then
            return n
        else
            if n > m then
                local tmp = s;
                s = t
                t = tmp
                n = m
                m = strLen(tmp)
            end
            local p = {}
            local d = {}
            for i = 1, n + 1 do
                p[i] = i - 1
            end
            for j = 1, m do
                local t_j = string.sub(t, j, j)
                d[1] = j
                for i = 1, n do
                    local sub = string.sub(s, i, i)
                    local cost = 0
                    if sub == t_j then
                        cost = 0
                    else
                        cost = 1
                    end
                    d[i + 1] = min(min(d[i] + 1, p[i + 1] + 1), p[i] + cost)
                end
                local _d = p;
                p = d;
                d = _d;
            end
            return p[n + 1]
        end
    end
end

local function compareSingleSeg(l, r)
    if (l == nil or #l == 0 or r == nil or #r == 0) then
        if ((l == nil or #l == 0) and (r == nil or #r == 0)) then
            return 1
        end
        return 0
    end

    local length
    local base
    local toDiff
    if strLen(l) > strLen(r) then
        length = strLen(l)
        base = l
        toDiff = r
    else
        length = strLen(r)
        base = r
        toDiff = l
    end
    local distance = getLevenshteinDistance(l, r);
    if (distance > length) then
        distance = length
    end
    return 1 - distance / length
end

local function fuzzyContains(tbl, value)
    local max = 0
    for k, v in ipairs(tbl) do
        local s = compareSingleSeg(v, value)
        if (s > max and s > 0.2) then
            max = s
        end
    end
    return max;
end

local function split(s, p)
    local rt = {}
    string.gsub(s, '[^' .. p .. ']+', function(w)
        table.insert(rt, w)
    end)
    return rt
end

local function fuzzyMatchSentence(s1, s2, freqWords)
    s1 = string.lower(s1)
    s2 = string.lower(s2)
    t1 = split(string.gsub(s1, "%s+", " "), " ")
    t2 = split(string.gsub(s2, "%s+", " "), " ")
    for i = 1, #freqWords do
        for j = 1, #t1 do
            if t1[j] == string.lower(freqWords[i]) then
                t1[j] = nil
            end
        end
        for j = 1, #t2 do
            if t2[j] == string.lower(freqWords[i]) then
                t2[j] = nil
            end
        end
    end
    s1 = ""
    s2 = ""
    for j = 1, #t1 do
        s1 = s1 .. t1[j]
    end
    for j = 1, #t2 do
        s2 = s2 .. t2[j]
    end

    local count1 = 0
    local length1 = 0;
    for k, v in ipairs(t1) do
        count1 = count1 + fuzzyContains(t2, v)
        length1 = length1 + 1
    end
    local percent1 = count1 / length1

    local count2 = 0
    local length2 = 0;
    for k, v in ipairs(t2) do
        count2 = count2 + fuzzyContains(t1, v)
        length2 = length2 + 1
    end
    local percent2 = count2 / length2
    --print("count1:" .. count1 .. ",count2:" .. count2)
    --print(compareSingleSeg(s1, s2))
    return compareSingleSeg(s1, s2) * 0.2 + (percent1 * 0.5 + percent2 * 0.5) * 0.8
end

local function justCompare(leftStr, rightStr)
    local leftLowerCase = string.lower(leftStr)
    local rightLoweCase = string.lower(rightStr)
    local leftArray = seg(leftLowerCase)
    local rightArray = seg(rightLoweCase)
    local all = compareSingleSeg(string.gsub(leftLowerCase, "_", ""), string.gsub(rightLoweCase, "_", ""))
    local t1 = compareSingleSeg(leftArray[1], rightArray[1]) * 0.475
    local t2 = compareSingleSeg(leftArray[3], rightArray[3]) * 0.475
    local t3 = compareSingleSeg(leftArray[2], rightArray[2]) * 0.05
    return all * 0.125 + (t1 + t2 + t3) * 0.875
end

local function compare(leftStr, rightStr)
    local leftLowerCase = string.lower(leftStr)
    local rightLoweCase = string.lower(rightStr)
    local leftArray = seg(leftLowerCase)
    local array = {}
    --中间名不为空 abc bca cab acb bac cba
    if (leftArray[2] ~= nil and #leftArray[2] ~= 0) then
        array[1] = leftLowerCase;
        array[2] = leftArray[2] .. "_" .. leftArray[3] .. "_" .. leftArray[1]
        array[3] = leftArray[3] .. "_" .. leftArray[1] .. "_" .. leftArray[2]
        array[4] = leftArray[1] .. "_" .. leftArray[3] .. "_" .. leftArray[2]
        array[5] = leftArray[2] .. "_" .. leftArray[1] .. "_" .. leftArray[3]
        array[6] = leftArray[3] .. "_" .. leftArray[2] .. "_" .. leftArray[1]
        --中间名为空 ac ca
    else
        array[1] = leftArray[3] .. "_" .. "_" .. leftArray[1]
        array[2] = leftArray[1] .. "_" .. "_" .. leftArray[3]
    end
    local max = -1;
    for i = 1, #array do
        local temp = justCompare(array[i], rightLoweCase)
        if (temp > max) then
            max = temp
        end
    end
    return max
end

function fuzzyMatch(rec, fullname, nameWeight, birthday, birthWeight, threshold, gender)
    local mapData = rec[BIN]
    if mapData == nil then
        return nil
    end
    local bestSimilarity = 0;
    local result
    for key in map.keys(mapData) do
        local asNameItem = mapData[key]
        local nameSimilarity = compare(fullname, key)
        local birthSimilarity = 0;
        if (birthday == asNameItem['birthday'] and birthday ~= nil) then
            birthSimilarity = 1;
        end
        local similarity = (nameSimilarity * nameWeight) + (birthSimilarity * birthWeight);

        --
        local genderIsSame = false;
        if (gender == nil or (gender == asNameItem['gender'])) then
            genderIsSame = true;
        end

        --符合条件
        if (similarity >= threshold and genderIsSame) then
            --比之前的更好
            if (similarity > bestSimilarity) then
                bestSimilarity = similarity
                result = asNameItem
            end
        end
    end
    if result ~= nil then
        result['degree'] = string.format("%0.3f", bestSimilarity)
    end
    return result
end

function corpNameFuzzy(rec, registerCode, needFuzzyMatch, corpName, matchDegree, freqWords)
    local mapData = rec[BIN]
    if (nil == mapData) then
        return nil
    end
    local best = 0;
    local bestResult = null;
    local preSameCode = false;
    for key in map.keys(mapData) do
        local json = mapData[key]
        local asCode = json["enterpriseCode"]
        local codeMatch = false;
        if (isEmpty(asCode) or isEmpty(registerCode)) then
            codeMatch = false;
        elseif string.lower(asCode) == string.lower(registerCode) then
            codeMatch = true;
        end
        local sml = 0

        if (needFuzzyMatch == 1) then
            local asName = json["enterpriseName"]
            if (isEmpty(asName) or isEmpty(corpName)) then
                sml = 0
            else
                asName = trim(asName);
                corpName = trim(corpName);
                --sml = compareSingleSeg(asName, corpName)
                sml = fuzzyMatchSentence(asName, corpName, freqWords)
            end
        end
        if (codeMatch) then
            if ((nil == bestResult) or (not preSameCode) or (preSameCode and sml > best)) then
                bestResult = json
                best = sml;
            end
            preSameCode = true
            if (needFuzzyMatch ~= 1) then
                --因为是注册号精准匹配，所以一旦匹配上就是最佳纪录，不用去后面找更好的；模糊匹配则不然，因为后面可能有更加匹配的记录
                break
            end
        elseif ((not preSameCode) and sml > best and sml >= matchDegree and needFuzzyMatch == 1) then
            bestResult = json
            best = sml;
        end
    end
    if bestResult ~= nil then
        if (needFuzzyMatch == 1) then
            bestResult["enterpriseNameSimilarity"] = string.format("%0.3f", best)
        end
        if (preSameCode) then
            bestResult["enterpriseCodeEquals"] = true
        else
            bestResult["enterpriseCodeEquals"] = false
        end
    end
    return bestResult
end
