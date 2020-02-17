var timeFormat = 'YYYY-MM-DD h:mm:ss';
var apiUrlTemp = "http://arduino-temperature-ws.herokuapp.com/location";
var apiUrlCoal = "http://arduino-temperature-ws.herokuapp.com/coal-consumption/total";
var apiUrlCoalSupply = "http://arduino-temperature-ws.herokuapp.com/coal-supply";
var chartTitle = "Wykres temperatury i spalania";
var lastTemp0, lastTemp1, lastTemp2, lastDate0, lastDate1, lastDate2, temp0values, temp1values, temp2values;
var coalHourValues, lastCoalHourValue, lastCoalHourDate, coalDayValues, lastCoalDayValue, lastCoalDayDate, coalMonthValues, lastCoalMonthValue, lastCoalMonthDate, coalYearValues, lastCoalYearValue, lastCoalYearDate;
var myChart;
var lastDay = formatDate(new Date(new Date().getTime() - (24 * 60 * 60 * 1000)));
var lastWeek = formatDate(new Date(new Date().getTime() - (7 * 24 * 60 * 60 * 1000)));
var lastMonth = formatDate(new Date(new Date().getTime() - (31 * 7 * 24 * 60 * 60 * 1000)));
var lastYear = formatDate(new Date(new Date().getTime() - (366 * 31 * 7 * 24 * 60 * 60 * 1000)));

 $("#chart_select").change(function () {
	myChart.destroy();
    if (this.value == 'hourly'){
		var t0values = temp0values.filter(function(item) {
		  return item.x > lastDay;
		});
		var t1values = temp1values.filter(function(item) {
		  return item.x > lastDay;
		});
		var t2values = temp2values.filter(function(item) {
		  return item.x > lastDay;
		});
		var cvalues = coalHourValues.filter(function(item) {
		  return item.x > lastDay;
		});
		BuildChart(t0values, t1values, t2values, cvalues, 'hour', 'YYYY-MM-DD HH:mm')
	}
	else if (this.value == 'daily'){
		var t0values = temp0values.filter(function(item) {
			return item.x > lastMonth;
		});
		var t1values = temp1values.filter(function(item) {
			return item.x > lastMonth;
		});
		var t2values = temp2values.filter(function(item) {
			return item.x > lastMonth;
		});
		var cvalues = coalDayValues.filter(function(item) {
			return item.x > lastMonth;
		});
		BuildChart(t0values, t1values, t2values, cvalues, 'day', 'YYYY-MM-DD')
	}
	else if (this.value == 'monthly'){
		var t0values = temp0values.filter(function(item) {
			return item.x > lastYear;
		});
		var t1values = temp1values.filter(function(item) {
			return item.x > lastYear;
		});
		var t2values = temp2values.filter(function(item) {
			return item.x > lastYear;
		});
		var cvalues = coalMonthValues.filter(function(item) {
			return item.x > lastYear;
		});
		BuildChart(t0values, t1values, t2values, cvalues, 'month', 'MMM YYYY')
	}
	else if (this.value == 'yearly'){
		BuildChart(temp0values, temp1values, temp2values, coalYearValues, 'year', 'YYYY')
	}
});


function formatDate(d) {
     var month = '' + (d.getMonth() + 1),
         day = '' + d.getDate(),
         year = d.getFullYear(),
         hours = '' + d.getHours(),
         minutes = '' + d.getMinutes(),
         seconds = '' + d.getSeconds();

     if (month.length < 2) month = '0' + month;
     if (day.length < 2) day = '0' + day;
     if (hours.length < 2) hours = '0' + hours;
     if (minutes.length < 2) minutes = '0' + minutes;
     if (seconds.length < 2) seconds = '0' + seconds;

     return year + '-' + month + '-' + day + ' ' + hours + ':' + minutes + ':' + seconds;
 }


 function BuildTables(){
	for(var i = 0; i < coalYearValues.length; i++){
		var div = document.createElement("div");
		var date = document.createTextNode(coalYearValues[i].x);
		var consumptionValue = document.createTextNode(coalYearValues[i].y);
		var year = coalYearValues[i].x.substring(0,4);
		$('#coal_consumption_history').append(div);
		//document.getElementById("coal_consumption_history").appendChild(div);
		var monthValues = coalMonthValues.filter(function(item) {
			return item.x.substring(0,4) == year;
		});
		for(var j = 0; j < monthValues.length; j++){
			var table = document.createElement("table");
			table.setAttribute("class", "coalConsumptionTable");
			var tr = document.createElement("tr");
			var th1 = document.createElement("th");
			var th2 = document.createElement("th");
			var consumptionValue = document.createTextNode(monthValues[j].y);
			var yearMonth = monthValues[j].x.substring(0,7);
			var yearMonthDate = document.createTextNode(yearMonth);
			th1.appendChild(yearMonthDate);
			th2.appendChild(consumptionValue);
			tr.appendChild(th1);
			tr.appendChild(th2);
			table.appendChild(tr);
			var dayValues = coalDayValues.filter(function(item) {
				return item.x.substring(0,7) == yearMonth;
			});
			for(var k = 0; k < dayValues.length; k++){
				var tr = document.createElement("tr");
				var td1 = document.createElement("td");
				var td2 = document.createElement("td");
				var consumptionValue = document.createTextNode(dayValues[k].y);
				var yearMonthDay = dayValues[k].x.substring(0,10);
				var yearMonthDayDate = document.createTextNode(yearMonthDay);
				td1.appendChild(yearMonthDayDate);
				td2.appendChild(consumptionValue);
				tr.appendChild(td1);
				tr.appendChild(td2);
				table.appendChild(tr);
				div.appendChild(table);
			}
		}
	}
 }


function BuildChart(temp0values, temp1values, temp2values, coalValues, timeUnit, toolTipFormat) {
    var data = {
        datasets: [{
			label: 'kotlownia', // Name the series
			yAxisID: "temperature",
            data: temp0values,
			fill: false,
			borderColor: 'rgba(200, 0, 200, 0.5)',
			borderWidth:1,
			pointRadius:'0'
		},
		{
            label: 'piec', // Name the series
			yAxisID: "temperature",
            data: temp1values,
			fill: false,
			borderColor: 'rgba(0, 200, 200, 0.5)',
			borderWidth:1,
			pointRadius:'2'
		},
		{
			label: 'dwor', // Name the series
			yAxisID: "temperature",
            data: temp2values,
			fill: false,
			borderColor: 'rgba(200, 200, 0, 0.5)',
			borderWidth:1,
			pointRadius:'2'
		},
		{
			label: 'spalanie', // Name the series
			yAxisID: "coal",
			type: 'bar',
            data: coalValues,
			backgroundColor: 'rgba(150, 150, 150, 0.5)',
			borderColor: 'rgba(150, 150, 150, 0.5)'
		}
		]
    };

    var ctx = document.getElementById("myChart").getContext('2d');

    myChart = new Chart(ctx, {
        type: 'line',
        data: data,
        options: {
			animation: false,
            responsive: true, // Instruct chart js to respond nicely.
			title:      {
                display: true,
				fontSize: 24,
                text:    chartTitle
            },
            scales: {
                xAxes: [{
					type:       "time",
					time: {
					  tooltipFormat: toolTipFormat,
					  unit: timeUnit,
					  displayFormats: {
						 hour: 'YYYY-MM-DD HH:mm'
					  }
					},
                    scaleLabel: {
                        display: true,
						fontSize: 16,
                        labelString: 'Data'
                    }
                }],
                yAxes: [{
					id: "temperature",
					position: "left",
                    scaleLabel: {
                        display: true,
						fontSize: 16,
                        labelString: 'Temperatura (w stopniach Celsjusza)'
                    }
                },
				{
					id: "coal",
					position: "right",
                    scaleLabel: {
                        display:     true,
						fontSize: 16,
                        labelString: 'Spalanie węgla (w kg)'
                    },
					ticks: {
						beginAtZero: true
					}
                }]
            },
        }
    });

    return myChart;
}



var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
      var json = JSON.parse(this.response);
		// Map json labels  back to values array
		temp0values = json[0].temperatures.map(function (e) {
			lastDate0 = json[0].temperatures[json[0].temperatures.length-1].x;
			lastTemp0 = json[0].temperatures[json[0].temperatures.length-1].y;
			$("#date0").html(moment(lastDate0).format('YYYY-MM-DD HH:mm:ss'));
			$("#temp0").html(lastTemp0 + " &#176;C");
			return e;
		});
		temp1values = json[1].temperatures.map(function (e) {
			lastDate1 = json[1].temperatures[json[1].temperatures.length-1].x;
			lastTemp1 = json[1].temperatures[json[1].temperatures.length-1].y;
			$("#date1").html(moment(lastDate1).format('YYYY-MM-DD HH:mm:ss'));
			$("#temp1").html(lastTemp1 + " &#176;C");
			return e;
		});
		temp2values = json[2].temperatures.map(function (e) {
			lastDate2 = json[2].temperatures[json[2].temperatures.length-1].x;
			lastTemp2 = json[2].temperatures[json[2].temperatures.length-1].y;
			$("#date2").html(moment(lastDate2).format('YYYY-MM-DD HH:mm:ss'));
			$("#temp2").html(lastTemp2 + " &#176;C");
			return e;
		});

    }
  };
  xhttp.open("GET", apiUrlTemp, false);
  xhttp.send();

  var xhttpCoal = new XMLHttpRequest();
  xhttpCoal.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
      var json = JSON.parse(this.response);
		// Map json labels  back to values array
		coalHourValues = json[0].map(function (e) {
			return e;
		});
		coalDayValues = json[1].map(function (e) {
			return e;
		});
		coalMonthValues = json[2].map(function (e) {
			return e;
		});
		coalYearValues = json[3].map(function (e) {
			return e;
		});
    }
  };
  xhttpCoal.open("GET", apiUrlCoal, false);
  xhttpCoal.send();

  var xhttpCoalSupply = new XMLHttpRequest();
  xhttpCoalSupply.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
        $("#coalSupplyDate").html(formatDate(new Date()));
		$("#coalSupplyValue").html((Math.round(this.response * 100) / 100).toFixed(3).replace('.',',') + " kg");
    }
  };
  xhttpCoalSupply.open("GET", apiUrlCoalSupply, false);
  xhttpCoalSupply.send();

	var t0values = temp0values.filter(function(item) {
		return item.x > lastDay;
	});
	  var t1values = temp1values.filter(function(item) {
	  return item.x > lastDay;
	});
	  var t2values = temp2values.filter(function(item) {
	  return item.x > lastDay;
	});
	var cvalues = coalHourValues.filter(function(item) {
	  return item.x > lastDay;
	});

	BuildTables();

  BuildChart(t0values, t1values, t2values, cvalues, 'hour', 'YYYY-MM-DD HH:mm');
