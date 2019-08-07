var data = {
    "xAxis":[["1月","2月"],["甲","乙","丙"],["a","b"]],
    "xAxisName":["月份","班次","类型"],
    "legend":["平均温度","蒸发量","降水量"],
    "series":{
        "平均温度":[[[12,52],[23,52],[12,52]],[[12,52],[23,52],[12,52]]],
        "蒸发量":[[[12,52],[23,52],[12,52]],[[12,52],[23,52],[12,52]]],
        "降水量":[[[12,52],[23,52],[12,52]],[[12,52],[23,52],[12,52]]]
    }
};
console.log(data);
// eq:默认取第二个,只取平均温度为例
var select = [1,0,2];
var tempdata = {};



function putX(xAxis,select,tempX,index){
    if(index >= select.length-1){
        tempX = xAxis[select[index]];
    }else{
        putX(xAxis,select,tempX,index);
        tempX = addTwoArr(tempX,xAxis[select[index]]);
    }
}

function addTwoArr(arr1,arr2){
    var arr = [];
    for(var i = 0;i<arr1.length;i++){
        for(var j = 0;j<arr2.length;j++){
            arr.push(arr1[i]+arr2[j]);
        }
    }
    return arr;
}

//
function getarr(xAxis,data,depth,select,tempdata){
    //到最后一层
    if(depth>=select-1){

    }

}