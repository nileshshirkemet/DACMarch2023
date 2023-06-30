// console.log('File Tested');

// console.log( 20*'20');
// console.log( 20+'20');
// console.log( 20+'m');

document.getElementById('x1').onclick = ()=>{
    // console.log('Click Working');
    
    var P = document.getElementById('m1').value;
    console.log(P , typeof P);

    P = parseInt(P);
    console.log(P, typeof P);

    var R = document.getElementById('m2').value;
    R = parseFloat(R);

    R = R/12/100;

    var N = document.getElementById('m3').value;
    N = parseInt(N);

    N = N*12;

    var EMI = P * R * (1+R)**N / ( (1+R)**N-1) ;
    console.log(EMI);

    document.getElementById('p1').innerHTML = `
        EMI = ${Math.round(EMI)}
    `

    document.getElementById('p2').innerHTML = `
        Amount : ${P}
    `;

    document.getElementById('p3').innerHTML = `
        Payable Amount : ${EMI * N}
    `;

    document.getElementById('p4').innerHTML = `
        Interest Amount : ${EMI * N - P}
    `;

    ///////////////
    Highcharts.chart('container', {
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false,
            type: 'pie'
        },
        title: {
            text: 'Browser market shares in May, 2020',
            align: 'left'
        },
        tooltip: {
            pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
        },
        accessibility: {
            point: {
                valueSuffix: '%'
            }
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                dataLabels: {
                    enabled: true,
                    format: '<b>{point.name}</b>: {point.percentage:.1f} %'
                }
            }
        },
        series: [{
            name: 'Brands',
            colorByPoint: true,
            data: [
            {
                name: 'Interest',
                y: EMI * N - P,
                sliced: true,
                selected: true
            }, {
                name: 'Loan Amount',
                y: P
            }]
        }]
    });
    ////////////////
}