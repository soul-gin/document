--[[

    开放接口
    grandTotal      累计
    maximum         最大
    minimum         最小
    topN            topN


    updateValueGrandTotal
    updateValueReplace
    updateMapGrandTotal
    updateMapReplace
    updateMax
    updateMin


]]--


local EARLIEST_FLAG = "earliest";
local RECENT_FLAG = "recent";


--[[
    rec Record 记录
    binName string 列名
    metricId string 指标Id
    startSlice string/number 开始时间片
    endSlice string/number 结束实时间片
]]--
function grandTotal(rec, binName, metricId, startSlice, endSlice)

    local sum = 0;
    if not aerospike:exists(rec) then
        return 0;
    end

    local binVal = rec[binName]
    if (binVal == nil) then
        return 0;
    end

    for k, v in map.pairs(binVal) do
        if (string.match(k, metricId) and tostring(k) >= tostring(metricId .. startSlice) and tostring(k) <= tostring(metricId .. endSlice)) then
            sum = sum + v
        end
    end

    return sum;
end

local function removeLast(zbdata, metricId, maxSize)

    local tmp = map()
    local size = 0
    for key, value in map.pairs(zbdata) do

        if string.match(key, metricId) then
            tmp[key] = value
            size = size + 1
        end

    end

    local minvkey = nil
    if(size > maxSize) then
        for k, v in map.pairs(tmp) do
            if(minvkey) then
                if(tostring(k) < tostring(minvkey)) then
                    minvkey = k
                end

            else
                minvkey = k
            end
        end
        map.remove(zbdata,minvkey)
    end

end


local function removeMinTop(zbdata, maxSize)

    local mink = nil;
    local minv = nil;
    local size = 0;
    if(maxSize > 0) then
        for k, v in map.pairs(zbdata) do
            if(minv == nil) then
                mink = k;
                minv = v;
            end

            if(minv > v) then
                minv = v;
                mink = k;
            end
            size = size +1;
        end
    end

    if(size > maxSize and mink ~= nil ) then
        map.remove(zbdata,mink)
    end

end

--[[
    数据累加

    rec Record 记录
    binName number 列名
    metricId string 指标Id
    val number 累加值
    maxSize number 分片个数 默认10

    描述：数据格式为  key：指标1+T1，value：1
]]--
function updateValueGrandTotal(rec, binName, metricId, timeSlice, val, maxSize)

    if not aerospike:exists(rec) then
        aerospike:create(rec)
    end

    if maxSize == nil then
        maxSize = 10
    end

    local binVal = rec[binName]
    if (binVal == nil) then
        binVal = map();
    end

    local key = metricId .. timeSlice

    local value = binVal[key]

    if (value == nil) then
        value = val
    else
        value = value + val
    end

    binVal[key] = value

    removeLast(binVal, metricId, maxSize)

    rec[binName] = binVal

    aerospike:update(rec)

    return value

end


--[[
    数据替换

    rec Record 记录
    binName number 列名
    metricId string 指标Id
    val number 累加值
    maxSize number 分片个数 默认10

    描述：数据格式为  key：指标1+T1，value：1
]]--
function updateValueReplace(rec, binName, metricId, timeSlice, val, maxSize)

    if not aerospike:exists(rec) then
        aerospike:create(rec)
    end

    if maxSize == nil then
        maxSize = 10
    end

    local binVal = rec[binName]
    if (binVal == nil) then
        binVal = map();
    end

    local key = metricId .. timeSlice

    binVal[key] = val

    removeLast(binVal, metricId, maxSize)

    rec[binName] = binVal

    aerospike:update(rec)


end



--[[
    数据累加
    rec Record 记录
    binName number 列名
    metricId string 指标Id
    val number 累加值
    maxSize number 分片个数 默认10

    描述：数据格式为  key：指标2+T2，value：{f:2,l:3}  updateMapGrandTotal(rec,binName,metricId,timeSlice,f,5,10) ===> key：指标2+T2，value：{f:5,l:3}
]]--
function updateMapGrandTotal(rec, binName, metricId, timeSlice, flag, val, maxSize,maxCount)

    if not aerospike:exists(rec) then
        aerospike:create(rec)
    end

    if maxSize == nil then
        maxSize = 10
    end

    if maxCount == nil then
        maxCount = 50
    end

    local binVal = rec[binName]
    if (binVal == nil) then
        binVal = map();
    end

    local key = metricId .. timeSlice

    local data = binVal[key]
    if (data == nil) then
        data = map()
    end

    local value = data[flag]

    removeMinTop(data,maxCount)

    if (value == nil) then
        value = val
    else
        value = value + val
    end

    data[flag] = value

    binVal[key] = data

    removeLast(binVal, metricId, maxSize)

    rec[binName] = binVal

    aerospike:update(rec)

    return value

end


--[[
    数据替换
    rec Record 记录
    binName number 列名
    metricId string 指标Id
    val number 累加值
    maxSize number 分片个数 默认10

    描述：数据格式为  key：指标2+T2，value：{f:2,l:3}  updateMapReplace(rec,binName,metricId,timeSlice,f,5,10) ===> key：指标2+T2，value：{f:5,l:3}
]]--
function updateMapReplace(rec, binName, metricId, timeSlice, flag, val, maxSize)

    if not aerospike:exists(rec) then
        aerospike:create(rec)
    end

    if maxSize == nil then
        maxSize = 10
    end

    local binVal = rec[binName]
    if (binVal == nil) then
        binVal = map();
    end

    local key = metricId .. timeSlice

    local data = binVal[key]
    if (data == nil) then
        data = map()
    end

    data[flag] = val

    removeLast(binVal, metricId, maxSize)

    rec[binName] = binVal

    aerospike:update(rec)

    return val

end



--[[
    更新最大值
    rec Record 记录
    binName number 列名
    metricId string 指标Id
    val number 比较值
    maxSize number 分片个数 默认10
]]
function updateMax(rec, binName, metricId, timeSlice, val, maxSize)

    if not aerospike:exists(rec) then
        aerospike:create(rec)
    end

    if maxSize == nil then
        maxSize = 10
    end

    local binVal = rec[binName]
    if (binVal == nil) then
        binVal = map();
    end

    local key = metricId .. timeSlice

    local value = binVal[key]

    if (value == nil) then
        value = val
    elseif(value < val)then
        value = val
    end

    binVal[key] = value

    removeLast(binVal, metricId, maxSize)

    rec[binName] = binVal

    aerospike:update(rec)

    return value
end


--[[
    更新最小值
    rec Record 记录
    binName number 列名
    metricId string 指标Id
    val number 比较值
    maxSize number 分片个数 默认10
]]--
function updateMin(rec, binName, metricId, timeSlice, val, maxSize)

    if not aerospike:exists(rec) then
        aerospike:create(rec)
    end

    if maxSize == nil then
        maxSize = 10
    end

    local binVal = rec[binName]
    if (binVal == nil) then
        binVal = map();
    end

    local key = metricId .. timeSlice

    local value = binVal[key]

    if (value == nil) then
        value = val
    elseif(value > val)then
        value = val
    end

    binVal[key] = value

    removeLast(binVal, metricId, maxSize)

    rec[binName] = binVal

    aerospike:update(rec)

    return value
end



--[[
    获取最大值
    rec Record 记录
    binName string 列名
    metricId string 指标Id
    startSlice string/number 开始时间片
    endSlice string/number 结束实时间片
]]--
function maximum(rec, binName, metricId,startSlice,endSlice)

    if not aerospike:exists(rec) then
        return 0.0;
    end

    local binVal = rec[binName]

    if (binVal == nil) then
        return 0.0;
    end

    local max = nil

    for k, v in map.pairs(binVal) do
        if max == nil then
            max = v
        end
        if(tostring(k) >= tostring(metricId..startSlice) and tostring(k) <= tostring(metricId..endSlice)) then
            if max < v then
                max = v
            end
        end
    end

    return max;

end

--[[
    获取最小值
    rec Record 记录
    binName string 列名
    metricId string 指标Id
    startSlice string/number 开始时间片
    endSlice string/number 结束实时间片
]]--

function minimum(rec, binName, metricId,startSlice,endSlice)

    if not aerospike:exists(rec) then
        return 0.0;
    end

    local binVal = rec[binName]

    if (binVal == nil) then
        return 0.0;
    end

    local min = nil

    for k, v in map.pairs(binVal) do

        if min == nil then
            min = v
        end

        if(tostring(k) >= tostring(metricId..startSlice) and tostring(k) <= tostring(metricId..endSlice)) then
            if min > v then
                min = v
            end
        end
    end

    return min;

end


--[[
 table  k v 反转
 egg. {a=100,b=200} ==> {100=a,200=b}
]]--
local function revert(tab)

    if tab == nil then
        return {}
    end

    local revert = {}
    for k, v in map.pairs(tab) do
        if (revert[v] ~= nil) then
            k = revert[v] .. "," .. k
        end
        revert[v] = k
    end

    return revert
end





--[[
    返回 table的key排序,tab为table
]]--
local function sortDes(tab)

    if tab ==nil then
        return {}
    end
    local des = {}
    for key, _ in pairs(tab) do
        table.insert(des, key)
    end

    table.sort(des, function(a, b)
        return a > b
    end)

    return des
end


--[[
    返回 table的key排序,递增  tab为userdata
]]--
local function sortAes(tab)

    if tab ==nil then
        return {}
    end
    local des = {}
    for key, _ in map.pairs(tab) do
        table.insert(des, key)
    end

    table.sort(des, function(a, b)
        return tostring(a) < tostring(b)
    end)

    return des
end

--[[
    返回 table的key排序 递减
]]--
local function sortDes2(tab)

    if tab ==nil then
        return {}
    end
    local des = {}
    for key, _ in map.pairs(tab) do
        table.insert(des, key)
    end

    table.sort(des, function(a, b)
        return tostring(a) > tostring(b)
    end)

    return des
end

--[[
  根据tab 的sortKey(排序key) 获取前num个

]]--
local function topN(tab, sortKey, num)

    if( tab == nil or sortKey == nil) then
        return map()
    end

    local res = map()

    for key, val in pairs(sortKey) do
        if (num > 0) then
            res[tab[val]] = val
            num = num - 1;
            for word in string.gmatch(tab[val], ",") do
                num = num - 1;
            end
        else
            break
        end
    end

    return res;
end


--[[
    获取topN

    rec：记录
    binName:字段名
    metricId：指标Id
    num：前几个
]]--
function getTopn(rec, binName, metricId,startSlice,endSlice, num)

    if not aerospike:exists(rec) then
        return map()
    end

    local binVal = rec[binName]

    if (binVal == nil) then
        return map()
    end

    local m = map();

    for k, v in map.pairs(binVal) do
        if string.match(k, metricId) and tostring(k) <= tostring(metricId .. endSlice) and tostring(k) >= tostring(metricId .. startSlice) then
            m = map.merge(m, v, function(v1, v2)
                return v1 + v2
            end)
        end
    end

    if map.size(m) <=0 then
        return map()
    end

    local tab = revert(m)

    local sortKey = sortDes(tab)

    local topN = topN(tab, sortKey, num);

    return topN;

end



--[[
    更新集中度

    rec：记录
    binName:字段名
    metricId：指标Id
    timeSlice：时间分片
    hour：第几个小时
    val：累加值 默认1
]]--
function absorbedIn(rec, binName, metricId, timeSlice, hour, val,maxSize)

    if not aerospike:exists(rec) then
        aerospike:create(rec)
    end

    local binVal = rec[binName]
    if (binVal == nil) then
        binVal = map();
    end

    if (val == nil) then
        val = 1
    end

    local key = metricId .. timeSlice

    local value = binVal[key]

    --return value['sum']

    if (value == nil) then
        value = map()
    end

    if (value[hour] == nil) then
        value[hour] = val
    else
        value[hour] = value[hour] + val
    end

    if value['sum'] == nil then
        value['sum'] = 0
    end

    value['sum'] = value['sum'] + val

    binVal[key] = value

    removeLast(binVal, metricId, maxSize)

    rec[binName] = binVal

    aerospike:update(rec)

    return value

end



--[[
    获取事件集中在某小时超过阈值threshold

    rec：记录
    binName:字段名
    metricId：指标Id
    startSlice：起始时间分片
    endSlice：终止时间分片
    threshold：阈值
]]--
function howMuchAbsorbedIn(rec, binName, metricId, startSlice, endSlice, threshold)

    if not aerospike:exists(rec) then
        aerospike:create(rec)
    end

    local binVal = rec[binName]
    if (binVal == nil) then
        return 0;
    end

    local howMuch = 0;
    local thresholdInt = threshold*100;

    for key, value in map.pairs(binVal) do
        if (string.match(key, metricId) and tostring(key) >= tostring(metricId .. startSlice) and tostring(key) <= tostring(metricId .. endSlice)) then
            local sum = value['sum']
            if (sum == nil or sum <= 0) then
            else
                for k, v in map.pairs(value) do

                    if k ~= "sum" then
                    --  repeat
                            local result = v *100 / sum
                            if (result >= thresholdInt) then
                                howMuch = howMuch + 1
                                break
                            end

                    --    until true
                    end
                end
            end
        end
    end

    return howMuch
end



function updateRecentOrEarliest(rec, binName, metricId, timeSlice, flag, val, maxSize)

    if not aerospike:exists(rec) then
        aerospike:create(rec)
    end

    if maxSize == nil then
        maxSize = 10
    end

    local binVal = rec[binName]
    if (binVal == nil) then
        binVal = map();
    end

    local key = metricId .. timeSlice

    local data = binVal[key]
    if (data == nil) then
        data = map()
        binVal[key] = data
    end

    --最早：存在不替换，不存在才替换
    --最近：替换
    if(flag == EARLIEST_FLAG) then
        local earliest = data[flag];
        if(earliest == nil) then
            data[flag] = val
        end
    else
        data[flag] = val
    end

    removeLast(binVal, metricId, maxSize)

    rec[binName] = binVal

    aerospike:update(rec)

    return val

end



--[[
    最近或最早
    rec Record 记录
    binName string 列名
    metricId string 指标Id
    timesSlice string/number 开始时间片
    flag string 最近或最早标识
]]--
function getRecentOrEarliest(rec,binName,metricId,startSlice,endSlice,flag)

    if not aerospike:exists(rec) then
        return 0
    end

    local binVal = rec[binName]

    if(binVal == nil) then
        return 0
    end

    local desTable = nil;
    if(flag == EARLIEST_FLAG) then
        desTable = sortAes(binVal);
    else
        if (flag == RECENT_FLAG) then
            desTable = sortDes2(binVal);
        end
    end

    if(desTable == nil) then
        return nil
    end

    for key, value in pairs(desTable) do
        if string.match(value, metricId) and tostring(value) >= tostring(metricId..startSlice) and tostring(value) <= tostring(metricId..endSlice) then
            if(binVal[value][flag] ~= nil)then
                return binVal[value][flag];
            end
        end
    end
    return nil;
end
