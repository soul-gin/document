-- local 是私有的
local MAX_SET_SIZE = 1000;
local MAX_ZB_SIZE = 100;
local MAX_ACTIVE_KEY_SIZE = 100;

local ZB_PARAM_SEP = ','
local ZB_PARAM_SUB_SEP = ':'
local VERSION = "2018-05-10 15:28:00"

local TIME_KEY_BIN = 'DATA'
local KEY_TIME_BIN = 'DATA1'
local EARTH_RADIUS = 6378137.0

function getInfo(r)
    local m = map()
    m['MAX_SET_SIZE'] = MAX_SET_SIZE
    m['MAX_ZB_SIZE'] = MAX_ZB_SIZE
    m['VERSION'] = VERSION
    m['MAX_ACTIVE_KEY_SIZE'] = MAX_ACTIVE_KEY_SIZE

    return m
end

-- 使用local 否则报错 attempt to call global 'split' (a nil value)
local function split(s, sep)
    if s == nil or sep == nil then
        return nil
    end

    local seplen = #sep

    if (seplen == nil or seplen <= 0) then
        return nil
    end

    local res = {}

    local temp = s
    local len = 0

    while true do
        len = string.find(temp, sep)
        if len ~= nil then
            local result = string.sub(temp, 1, len - 1)
            temp = string.sub(temp, len + seplen)
            table.insert(res, result)
        else
            table.insert(res, temp)
            break
        end
    end

    return res
end

-- zbKey:timeKey:zbValue:maxSize
--
local function getZbCommUpdateParam(str)
    if str == nil or #str <= 0 then
        return nil
    end
    local tmplist = split(str, ZB_PARAM_SUB_SEP)
    if #tmplist ~= 4 then
        return nil
    end
    local zbKey = tmplist[1]
    if zbKey == nil or #zbKey <= 0 then
        return nil
    end
    local timeKey = tmplist[2]
    if timeKey == nil or #timeKey <= 0 then
        return nil
    end

    local zbValue = tmplist[3]
    if zbValue == nil or #zbValue <= 0 then
        return nil
    end
    local zbValueNum = tonumber(zbValue)
    if zbValueNum == nil or zbValueNum <= 0 then
        return nil
    end

    local maxSize = tmplist[4]
    local maxSizeNum = tonumber(maxSize)
    if maxSizeNum == nil then
        maxSizeNum = 0
    end

    if (maxSizeNum <= 0 or maxSizeNum > MAX_ZB_SIZE) then
        maxSizeNum = MAX_ZB_SIZE
    end

    tmplist[3] = zbValueNum
    tmplist[4] = maxSizeNum

    return tmplist

end

--zbid:startTimeKey:endTimeKey
local function getZbCommQueryParam(str)
    if str == nil or #str <= 0 then
        return nil
    end
    local tmplist = split(str, ZB_PARAM_SUB_SEP)
    local num = #tmplist
    if num < 2 or num > 3 then
        return nil
    end
    local zbId = tmplist[1]
    if zbId == nil or #zbId <= 0 then
        return nil
    end

    local startTimeKey = tmplist[2]
    if startTimeKey == nil or #startTimeKey <= 0 then
        return nil
    end

    if (num <= 2) then
        tmplist[3] = nil
    end

    return tmplist

end

-- timeValue is long
local function isTimeValueMatch(timeValue, startTimeValue, endTimeValue)

    if timeValue == nil or startTimeValue == nil or timeValue <= 0 or startTimeValue <= 0 then
        return false
    end

    if timeValue < startTimeValue then
        return false
    end

    if endTimeValue and endTimeValue > 0 and (timeValue > endTimeValue) then
        return false
    end

    return true

end


-- timeString is string
local function isTimeStringMatch(timeStr, startTimeStr, endTimeStr)

    if timeStr == nil or startTimeStr == nil or #timeStr <= 0 or #startTimeStr <= 0 then
        return false
    end

    if timeStr < startTimeStr then
        return false
    end

    if endTimeStr and #endTimeStr > 0 and timeStr > endTimeStr then
        return false
    end

    return true

end

function getMaxSetSize(r)
    return MAX_SET_SIZE;
end

local function getVersion_(r)
    return VERSION
end

function getVersion(r)
    return getVersion_(r)
end

function getMapInfo(r)
    local m = map()
    return type(m)
end

function getType(rec, binName)
    --
    if (not aerospike:exists(rec)) then
        return 'record not exist'
    end
    binValue = rec[binName]
    if (binValue) then
        return '' .. type(binValue)
    end

    return 'bin is nil'

end

function maptest(r)
    local m = map()
    -- return type(m)
    m['a'] = 1
    m['b'] = 2
    m['c'] = 3
    m['a'] = nil
    -- 使用 remove 不会出现 a=nil
    map.remove(m, 'a')

    s = '' .. type(m) .. ',len=' .. #m
    -- Line: 37  Message: unexpected symbol near '['
    -- s = s .. #m .. m['a'] .. m['b'] .. ['c']
    m['info'] = s
    m['d'] = 6

    m['len'] = #m
    m['size'] = map.size(m)
    -- len=5, size=6


    bv = m['b']
    m['bv'] = bv

    s2 = ''
    --
    for k, v in map.pairs(m) do
        -- print(k, v)
        -- attempt to concatenate local 'v' (a nil value)
        if (k and v) then
            s2 = s2 .. k .. '=' .. v .. ';'
        end
    end

    m['s2'] = s2

    return m
end

function mapOpTest(rec, binName, optype, key, value)
    --
    if (value == nil) then
        value = ''
    end

    if (not aerospike:exists(rec)) then
        --
        rc = aerospike:create(rec)
        if (rc == nil) then
            return -1
        end
    end

    local datamap = rec[binName]
    if (datamap == nil) then
        datamap = map()
    end

    if ('put' == optype) then
        --
        datamap[key] = value
    end

    if ('remove' == optype) then
        --
        map.remove(datamap, key)
    end

    if ('size' == optype) then
        return map.size(datamap)
    end

    if ('info' == optype) then
        str = ''
        for k, v in map.pairs(datamap) do
            if (k and v) then
                str = str .. k .. '=' .. v .. ';'
            end
        end
        return str

    end

    rec[binName] = datamap
    rc = aerospike:update(rec);
    if (rc ~= nil and rc ~= 0) then

        return -2
    end

    return 0


end

function doAdd(rec, binName, mapKey, valueToAdd)
    if (not aerospike:exists(rec)) then
        rc = aerospike:create(rec);
        if (rc == nil) then
            -- warn("[ERROR] Problem creating record");
            -- error("ERROR creating record");
            return 1;
        end
        local m = map();
        m[mapKey] = valueToAdd;
        rec[binName] = m;
    else
        local binVal = rec[binName];
        if (binVal == nil) then
            local m = map();
            m[mapKey] = valueToAdd;
            rec[binName] = m;
        else
            if (binVal[mapKey] == nil) then
                binVal[mapKey] = valueToAdd;
            else
                binVal[mapKey] = binVal[mapKey] + valueToAdd;
            end
            rec[binName] = binVal;
        end
    end
    rc = aerospike:update(rec);
    -- trace("<CHECK> Check Update Result(%s)", tostring(rc));
    if (rc ~= nil and rc ~= 0) then
        -- warn("[ERROR] Record update failed: rc(%s)", tostring(rc));
        -- error("ERROR updating the record");
        return 2;
    end
    return 0;
end

function updateSet2(rec, binName, mapKey, timeValue, maxSize)
    if (not aerospike:exists(rec)) then
        rc = aerospike:create(rec);
        if (rc == nil) then

            return 1;
        end
        local m = map();
        m[mapKey] = timeValue;
        rec[binName] = m;
    else
        local binVal = rec[binName];
        if (binVal == nil) then
            local m = map();
            m[mapKey] = timeValue;
            rec[binName] = m;
        else
            binVal[mapKey] = timeValue;
            rec[binName] = binVal;
        end
    end
    rc = aerospike:update(rec);
    if (rc ~= nil and rc ~= 0) then

        return 2;
    end
    return 0;
end

function updateSet(rec, binName, mapKey, timeValue, maxSize)
    --
    if (maxSize == nil or maxSize > MAX_SET_SIZE or maxSize <= 0) then
        maxSize = MAX_SET_SIZE
    end
    local binValue = nil;

    if (not aerospike:exists(rec)) then
        rc = aerospike:create(rec);
        if (rc == nil) then

            return 1;
        end
        local m = map();
        binValue = m
        rec[binName] = binValue
    else
        binValue = rec[binName];
        if (binValue == nil) then
            local m = map();
            binValue = m;
            rec[binName] = binValue;
        end
    end
    binValue[mapKey] = timeValue

    -- print('len=',#binValue)
    -- remove old keys
    local size = map.size(binValue)
    local minv = nil
    local minvkey = nil
    if (size > maxSize) then
        --
        for k, v in map.pairs(binValue) do
            --
            if (minv) then
                if (v < minv) then
                    minv = v
                    minvkey = k
                end

            else
                minv = v
                minvkey = k
            end
        end

        map.remove(binValue, minvkey)

    end

    rec[binName] = binValue
    --
    rc = aerospike:update(rec);
    if (rc ~= nil and rc ~= 0) then
        return 2;
    end
    return 0;

end

local function removeOldData(zbdata, maxSize)
    --
    if (zbdata == nil) then
        return
    end

    local size = map.size(zbdata)
    local minkey = nil
    if (size > maxSize) then
        --
        for k in map.keys(zbdata) do
            --
            if (minkey) then
                if (k < minkey) then
                    minkey = k
                end

            else
                minkey = k
            end
        end

        map.remove(zbdata, minkey)

    end

end

local function updateCommZbSingle(zbdatas, zbKey, timeKey, zbValue, maxSize)

    local zbdata = zbdatas[zbKey]
    if (zbdata == nil) then
        zbdata = map()
        zbdatas[zbKey] = zbdata
    end

    local zbitem = zbdata[timeKey]
    if (zbitem == nil) then
        zbitem = list()
        zbdata[timeKey] = zbitem
    end

    local sum = zbitem[1]
    local count = zbitem[2]
    local min = zbitem[3]
    local max = zbitem[4]

    if (sum == nil) then
        sum = zbValue
    else
        sum = sum + zbValue
    end

    if (count == nil) then
        count = 1
    else
        count = count + 1
    end

    if (min == nil) then
        min = zbValue
    else
        if (zbValue > 0 and zbValue < min) then
            min = zbValue
        end
    end

    if (max == nil) then
        max = zbValue
    else
        if (zbValue > 0 and zbValue > max) then
            max = zbValue
        end
    end

    zbitem[1] = sum
    zbitem[2] = count
    zbitem[3] = min
    zbitem[4] = max

    removeOldData(zbdata, maxSize)


end

function updateCommZb(rec, binName, zbKey, timeKey, zbValue, maxSize)
    if (maxSize == nil or maxSize <= 0 or maxSize > MAX_ZB_SIZE) then
        maxSize = MAX_ZB_SIZE
    end

    if (not aerospike:exists(rec)) then
        rc = aerospike:create(rec);
        if (rc == nil) then
            return 1;
        end

    end

    local zbdatas = rec[binName]
    if (zbdatas == nil) then
        zbdatas = map()
        --rec[binName] = zbdatas
    end

    updateCommZbSingle(zbdatas, zbKey, timeKey, zbValue, maxSize)

    -- 貌似需要需要 显式的加上这一句才能update 成功
    rec[binName] = zbdatas

    rc = aerospike:update(rec);
    if (rc ~= nil and rc ~= 0) then
        return 2;
    end

    return 0;
end




--
-- zbKey, timeKey,zbValue,maxSize
--
function updateCommZbBatch(rec, binName, params)

    if (not aerospike:exists(rec)) then
        rc = aerospike:create(rec);
        if (rc == nil) then
            return 1;
        end

    end

    local zbdatas = rec[binName]
    if (zbdatas == nil) then
        zbdatas = map()
    end

    local listtmp = split(params, ZB_PARAM_SEP)
    if listtmp == nil or #listtmp <= 0 then
        return 3
    end

    local sublisttmp = nil
    for k, v in pairs(listtmp) do
        sublisttmp = getZbCommUpdateParam(v)
        if sublisttmp then
            updateCommZbSingle(zbdatas, sublisttmp[1], sublisttmp[2], sublisttmp[3], sublisttmp[4])
        end
    end

    rec[binName] = zbdatas

    rc = aerospike:update(rec);
    if (rc ~= nil and rc ~= 0) then
        return 2;
    end

    return 0
end


--

function getSetCount(rec, binName, startTimeValue, endTimeValue)
    if (not aerospike:exists(rec)) then
        return 0
    end
    local data = rec[binName]
    if data == nil then
        return 0
    end
    local count = 0
    for k, v in map.pairs(data) do
        if isTimeValueMatch(v, startTimeValue, endTimeValue) then
            count = count + 1
        end
    end

    return count
end

local function getCommZbSingle(zbdatas, zbKey, startTimeKey, endTimeKey)

    local zbdata = zbdatas[zbKey]
    if zbdata == nil then
        return nil
    end
    local size = map.size(zbdata)
    if size <= 0 then
        return nil
    end

    local sum = 0;
    local count = 0;
    local min = nil;
    local max = nil;

    for k, v in map.pairs(zbdata) do
        if isTimeStringMatch(k, startTimeKey, endTimeKey) then
            sum = sum + v[1]
            count = count + v[2]

            if min == nil then
                min = v[3]
            else
                if v[3] < min then
                    min = v[3]
                end
            end

            if max == nil then
                max = v[4]
            else
                if v[4] > max then
                    max = v[4]
                end
            end

        end


    end

    if count <= 0 then
        return nil
    end

    local result = list()
    result[1] = sum
    result[2] = count
    result[3] = min
    result[4] = max

    return result

end

function getCommZb(rec, binName, zbKey, startTimeKey, endTimeKey)

    if (not aerospike:exists(rec)) then
        return nil
    end
    local zbdatas = rec[binName]
    if zbdatas == nil then
        return nil
    end
    local result = getCommZbSingle(zbdatas, zbKey, startTimeKey, endTimeKey)
    if result then
        return result
    end

    return nil
end

--zb1:startTimeKey1:endTimeKey1,zb2:startTimeKey2:endTimeKey2
function getCommZbBatch(rec, binName, params)
    if (not aerospike:exists(rec)) then
        return nil
    end
    local zbdatas = rec[binName]
    if zbdatas == nil then
        return nil
    end

    local listtmp = split(params, ZB_PARAM_SEP)
    if listtmp == nil or #listtmp <= 0 then
        return nil
    end

    local sublisttmp = nil
    local subresult = nil
    local zbKey = nil

    local result = map()

    for k, v in pairs(listtmp) do
        sublisttmp = getZbCommQueryParam(v)
        if sublisttmp then
            zbKey = sublisttmp[1]
            subresult = getCommZbSingle(zbdatas, zbKey, sublisttmp[2], sublisttmp[3])
            if subresult then
                result[zbKey] = subresult
            end
        end
    end

    return result
end

function putMapItem(rec, binName, key, value, maxsize)
    if (not aerospike:exists(rec)) then
        rc = aerospike:create(rec);
        if (rc == nil) then
            -- warn("[ERROR] Problem creating record");
            -- error("ERROR creating record");
            return 1;
        end
    end
    local datamap = rec[binName]
    if datamap == nil then
        datamap = map(maxsize)
    end

    datamap[key] = value

    rec[binName] = datamap

    rc = aerospike:update(rec);
    if (rc ~= nil and rc ~= 0) then
        return 2;
    end

    return 0


end

function putSetItem(rec, key, time)
    if (not aerospike:exists(rec)) then
        rc = aerospike:create(rec);
        if (rc == nil) then
            -- warn("[ERROR] Problem creating record");
            -- error("ERROR creating record");
            return 1;
        end
    end
    local timeAndKeyMap = rec[TIME_KEY_BIN]
    if timeAndKeyMap == nil then
        timeAndKeyMap = map()
    end

    local keyTimeMap = rec[KEY_TIME_BIN]
    if keyTimeMap == nil then
        keyTimeMap = map()
    end

    local timeOld = keyTimeMap[key]
    if (timeOld == nil) then
        timeOld = 0
    end

    if (time <= timeOld) then
        return 0
    end

    map.remove(timeAndKeyMap, timeOld .. "_" .. key)
    timeAndKeyMap[time .. "_" .. key] = ''
    keyTimeMap[key] = time

    rec[TIME_KEY_BIN] = timeAndKeyMap
    rec[KEY_TIME_BIN] = keyTimeMap

    rc = aerospike:update(rec);
    if (rc ~= nil and rc ~= 0) then
        return 2;
    end

    return 0


end

-- ******ivar start


local function buildIvar(datalist, zbValue)
    --
    local count = datalist[1]
    local sum = datalist[2]
    local ivar = datalist[3]

    if (count == nil or count == 0 or sum == nil or ivar == nil) then
        count = 1
        sum = zbValue
        ivar = 0
        datalist[1] = count
        datalist[2] = sum
        datalist[3] = ivar
        return
    end

    sumnew = sum + zbValue
    countnew = count + 1
    avg = sum / count
    avgnew = sumnew / countnew
    difnew = zbValue - avgnew
    difavg = avg - avgnew
    ivarnew = (ivar + difavg * difavg) * count + difnew * difnew
    ivarnew = ivarnew / countnew

    datalist[1] = countnew
    datalist[2] = sumnew
    datalist[3] = ivarnew

end

local function buildIvarForQuery(resultdatalist, datalist)

    local count0 = resultdatalist[1]
    local sum0 = resultdatalist[2]
    local ivar0 = resultdatalist[3]

    local count = datalist[1]
    local sum = datalist[2]
    local ivar = datalist[3]

    if (count0 == nil or count0 == 0 or sum0 == nil or ivar0 == nil) then
        count0 = count
        sum0 = sum
        ivar0 = ivar
        resultdatalist[1] = count0
        resultdatalist[2] = sum0
        resultdatalist[3] = ivar0
        return
    end

    avg0 = sum0 / count0
    avg = sum / count
    countnew = count0 + count;
    sumnew = sum0 + sum;
    avgnew = sumnew / countnew;

    dif1 = avg0 - avgnew;
    v1 = count0 * (ivar0 + dif1 * dif1);
    dif2 = avg - avgnew;
    v2 = count * (ivar + dif2 * dif2);
    ivarnew = (v1 + v2) / countnew;

    resultdatalist[1] = countnew
    resultdatalist[2] = sumnew
    resultdatalist[3] = ivarnew


end

local function updateIvarZbSingle(zbdatas, zbKey, timeKey, zbValue, maxSize)

    local zbdata = zbdatas[zbKey]
    if (zbdata == nil) then
        zbdata = map()
        zbdatas[zbKey] = zbdata
    end

    local zbitem = zbdata[timeKey]
    if (zbitem == nil) then
        zbitem = list()
        zbdata[timeKey] = zbitem
    end
    buildIvar(zbitem, zbValue)
    removeOldData(zbdata, maxSize)
end

function updateIvarZb(rec, binName, zbKey, timeKey, zbValue, maxSize)

    if (maxSize == nil or maxSize <= 0 or maxSize > MAX_ZB_SIZE) then
        maxSize = MAX_ZB_SIZE
    end

    if (not aerospike:exists(rec)) then
        rc = aerospike:create(rec);
        if (rc == nil) then
            return 1;
        end

    end

    local zbdatas = rec[binName]
    if (zbdatas == nil) then
        zbdatas = map()
        --rec[binName] = zbdatas
    end

    updateIvarZbSingle(zbdatas, zbKey, timeKey, zbValue, maxSize)

    rec[binName] = zbdatas

    rc = aerospike:update(rec);
    if (rc ~= nil and rc ~= 0) then
        return 2;
    end

    return 0;

end

-- zbKey, timeKey,zbValue,maxSize
--
function updateIvarZbBatch(rec, binName, params)

    if (not aerospike:exists(rec)) then
        rc = aerospike:create(rec);
        if (rc == nil) then
            return 1;
        end

    end

    local zbdatas = rec[binName]
    if (zbdatas == nil) then
        zbdatas = map()
    end

    local listtmp = split(params, ZB_PARAM_SEP)
    if listtmp == nil or #listtmp <= 0 then
        return 3
    end

    local sublisttmp = nil
    for k, v in pairs(listtmp) do
        -- sublisttmp = getZbIvarUpdateParam(v)
        sublisttmp = getZbCommUpdateParam(v)
        if sublisttmp then
            updateIvarZbSingle(zbdatas, sublisttmp[1], sublisttmp[2], sublisttmp[3], sublisttmp[4])
        end
    end

    rec[binName] = zbdatas

    rc = aerospike:update(rec);
    if (rc ~= nil and rc ~= 0) then
        return 2;
    end

    return 0
end

local function getIvarZbSingle(zbdatas, zbKey, startTimeKey, endTimeKey)

    local zbdata = zbdatas[zbKey]
    if zbdata == nil then
        return nil
    end
    local size = map.size(zbdata)
    if size <= 0 then
        return nil
    end

    local result = list()

    for k, v in map.pairs(zbdata) do
        if isTimeStringMatch(k, startTimeKey, endTimeKey) then
            buildIvarForQuery(result, v)
        end
    end
    local count = result[1]
    if count == nil or count <= 0 then
        return nil
    end

    return result

end

function getIvarZb(rec, binName, zbKey, startTimeKey, endTimeKey)

    if (not aerospike:exists(rec)) then
        return nil
    end
    local zbdatas = rec[binName]
    if zbdatas == nil then
        return nil
    end

    local result = getIvarZbSingle(zbdatas, zbKey, startTimeKey, endTimeKey)
    if result then
        return result
    end

    return nil
end

--zb1:startTimeKey1:endTimeKey1,zb2:startTimeKey2:endTimeKey2
function getIvarZbBatch(rec, binName, params)
    if (not aerospike:exists(rec)) then
        return nil
    end
    local zbdatas = rec[binName]
    if zbdatas == nil then
        return nil
    end

    local listtmp = split(params, ZB_PARAM_SEP)
    if listtmp == nil or #listtmp <= 0 then
        return nil
    end

    local sublisttmp = nil
    local subresult = nil
    local zbKey = nil

    local result = map()

    for k, v in pairs(listtmp) do
        -- sublisttmp = getZbIvarQueryParam(v)
        sublisttmp = getZbCommQueryParam(v)
        if sublisttmp then
            zbKey = sublisttmp[1]
            subresult = getIvarZbSingle(zbdatas, zbKey, sublisttmp[2], sublisttmp[3])
            if subresult then
                result[zbKey] = subresult
            end
        end
    end

    return result
end


-- ******ivar end


-- ****** active days start

function addActiveKey(rec, binName, key, maxsize)
    if (maxsize > MAX_ACTIVE_KEY_SIZE) then
        maxsize = MAX_ACTIVE_KEY_SIZE
    end

    if (not aerospike:exists(rec)) then
        rc = aerospike:create(rec);
        if (rc == nil) then
            -- warn("[ERROR] Problem creating record");
            -- error("ERROR creating record");
            return 1;
        end
    end
    local datamap = rec[binName]
    if datamap == nil then
        datamap = map()
    end

    local value = datamap[key]
    if value ~= nil then
        return 0
    end

    datamap[key] = ''
    removeOldData(datamap, maxsize)

    rec[binName] = datamap

    rc = aerospike:update(rec);
    if (rc ~= nil and rc ~= 0) then
        return 2;
    end

    return 0

end

function getActiveCount(rec, binName, startTimeKey, endTimeKey)

    local datamap = rec[binName]
    if datamap == nil then
        return nil
    end
    local size = map.size(datamap)
    if size <= 0 then
        return nil
    end

    local count = 0;

    for k in map.keys(datamap) do
        if isTimeStringMatch(k, startTimeKey, endTimeKey) then
            count = count + 1
        end
    end

    return count

end

-- ****** active days end

-- ****** distance start

local function rad(var)
    return var * math.pi / 180.0
end

local function calculateDistance(x1, y1, x2, y2)

    local radLat1 = rad(y1);
    local radLat2 = rad(y2);
    local a = radLat1 - radLat2;
    local b = rad(x1) - rad(x2)

    local s = 2 * math.asin(math.sqrt(math.pow(math.sin(a / 2), 2)
            + math.cos(radLat1) * math.cos(radLat2) * math.pow(math.sin(b / 2), 2)));

    s = s * EARTH_RADIUS;
    s = math.ceil(s * 10000) / 10000;

    return s;
end

function updateDistance(rec, binName, timestamp, longitude, latitude, maxsize)
    if (not aerospike:exists(rec)) then
        rc = aerospike:create(rec);
        if (rc == nil) then
            -- warn("[ERROR] Problem creating record");
            -- error("ERROR creating record");
            return 1;
        end
    end

    local datamap = rec[binName]

    if datamap == nil then
        datamap = map()
    end

    local info = map()
    info["x"] = longitude;
    info["y"] = latitude;

    datamap[timestamp] = info

    removeOldData(datamap, maxsize)

    rec[binName] = datamap

    rc = aerospike:update(rec);
    if (rc ~= nil and rc ~= 0) then
        return 2;
    end

    return 0
end

function queryDistance(rec, binName, startTime, endTime)

    local datamap = rec[binName]
    if datamap == nil then
        return nil
    end
    local size = map.size(datamap)
    if size <= 0 then
        return nil
    end

    local timekeys = {}
    local timekeysLength = 0;

    for k in map.keys(datamap) do

        if k >= startTime and k <= endTime then
            table.insert(timekeys, k)
            timekeysLength = timekeysLength + 1
        end
    end

    if timekeysLength <= 0 then
        return nil
    end

    local result = map()

    -- 按时间升序
    table.sort(timekeys);

    local lastTimeKey = timekeys[timekeysLength]

    if timekeysLength == 1 then
        result["distance"] = 0
        result["timeDiff"] = 0
        result["lastTime"] = lastTimeKey;
        result["lastPoint"] = datamap[lastTimeKey]

        return result
    end

    -- 经度
    local lastX;
    -- 维度
    local lastY;

    local distance = 0

    for key, value in pairs(timekeys) do

        local v = datamap[value]

        if lastX ~= nil and lastY ~= nil then
            distance = distance + calculateDistance(lastX, lastY, v["x"], v["y"])
        end

        lastX = v["x"]

        lastY = v["y"]

    end

    result["distance"] = distance
    result["timeDiff"] = lastTimeKey - timekeys[1]
    result["lastTime"] = lastTimeKey;
    result["lastPoint"] = datamap[lastTimeKey]

    return result
end

-- ****** distance end

function dsetIncludeCurrent(rec, value, startTs, endTs)
    local mapData = rec[TIME_KEY_BIN];
    if mapData == nil then
        return 1
    end
    mapData[value] = startTs;
    local count = 0;
    for key in map.keys(mapData) do
        local ts = mapData[key];
        if (ts <= endTs and ts >= startTs) then
            count = count + 1
        end
    end
    return count
end
