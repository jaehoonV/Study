
/* myChart */
const labels = [
    'January',
    'February',
    'March',
    'April',
    'May',
    'June',
];

const data = {
    labels: labels,
    datasets: [{
        label: 'test data',
        backgroundColor: 'rgb(255, 99, 132)',
        borderColor: 'rgb(255, 99, 132)',
        data: [0, 10, 5, 2, 20, 30, 45],
    }]
};

const config = {
    type: 'line',
    data: data,
    options: {}
};

const myChart = new Chart(
    document.getElementById('myChart'), config
);
/* myChart end*/

/* chart1 */
const ctx = document.getElementById('chart1');
const chart1 = new Chart(ctx, {
    type: 'bar',
    data: {
        labels: ['Red', 'Blue', 'Yellow', 'Green', 'Purple', 'Orange'],
        datasets: [{
            label: '# of Votes',
            data: [12, 19, 3, 5, 2, 3],
            backgroundColor: [
                'rgba(255, 99, 132, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 206, 86, 0.2)',
                'rgba(75, 192, 192, 0.2)',
                'rgba(153, 102, 255, 0.2)',
                'rgba(255, 159, 64, 0.2)'
            ],
            borderColor: [
                'rgba(255, 99, 132, 1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)',
                'rgba(75, 192, 192, 1)',
                'rgba(153, 102, 255, 1)',
                'rgba(255, 159, 64, 1)'
            ],
            borderWidth: 1
        }]
    },
    options: {
        plugins: {
            legend: {
                display: false,
            }
        },
        scales: {
            y: {
                beginAtZero: true
            }
        }
    }
});
/* chart1 end*/

/* chart2 */
const chart2 = new Chart(document.getElementById('chart2'), {
    type: 'bar',
    data: {
        labels: ['요청', '진행', '완료', '보류'],
        datasets: [{
            label: '업무상태',
            data: [2, 8, 5, 1],
            backgroundColor: [
                '#00b2ff',
                '#00b01c',
                '#402a9d',
                '#777'
            ],
            borderColor: [
                '#00b2ff',
                '#00b01c',
                '#402a9d',
                '#777'
            ],
            borderWidth: 1
        }]
    },
    options: {
        plugins: {
            legend: {
                display: false,
            }
        },
        scales: {
            y: {
                beginAtZero: true
            }
        }
    }
});
/* chart2 end */

/* chart3 */
const chart3_data = {
    labels: ['요청', '진행', '완료', '보류'],
    datasets: [{
        label: '업무상태',
        data: [2, 8, 5, 1],
        backgroundColor: [
            '#00b2ff',
            '#00b01c',
            '#402a9d',
            '#777'
        ],
        hoverOffset: 5
    }]
};
const chart3_config = {
    type: 'doughnut',
    data: chart3_data,
};
const chart3 = new Chart(document.getElementById('chart3'), chart3_config);
/* chart3 end */

/* chart4 */
const chart4_data = {
    labels: ['요청', '진행', '완료', '보류'],
    datasets: [{
        label: '업무상태',
        data: [2, 8, 5, 1],
        backgroundColor: [
            '#00b2ff',
            '#00b01c',
            '#402a9d',
            '#777'
        ],
        hoverOffset: 5
    }]
};
const chart4_config = {
    type: 'pie',
    data: chart4_data,
};
const chart4 = new Chart(document.getElementById('chart4'), chart4_config);
/* chart4 end */

/* chart5 */
const chart5_data = {
    labels: ['1월', '2월', '3월', '4월', '5월', '6월'],
    datasets: [{
        label: '요청',
        data: [2, 8, 5, 1, 3, 9],
        backgroundColor: [
            '#00b2ff'
        ],

    }, {
        label: '진행',
        data: [5, 6, 1, 4, 3, 8],
        backgroundColor: [
            '#00b01c'
        ],
    }, {
        label: '완료',
        data: [3, 2, 7, 4, 1, 9],
        backgroundColor: [
            '#402a9d'
        ],
    }, {
        label: '보류',
        data: [5, 2, 2, 6, 5, 4],
        backgroundColor: [
            '#777'
        ],
    }
    ]
};

const chart5_config = {
    type: 'bar',
    data: chart5_data,
    options: {
        scales: {
            y: {
                beginAtZero: true
            }
        }
    }
};
const chart5 = new Chart(document.getElementById('chart5'), chart5_config);

/* chart5 end */

/* chart6 */
function random_data_for_bubble(cnt){
    let output_data = [];
    for(let i = 0; i < cnt; i++){
        let x = Math.floor(Math.random() * 100);
        let y = Math.floor(Math.random() * 100);
        let r = Math.floor(Math.random() * 4);
        output_data.push({x, y, r});
    }
    return output_data;
}

const chart6_data1 = random_data_for_bubble(500);
const chart6_data2 = random_data_for_bubble(500);

const chart6_data = {
    labels:  ['1월', '2월', '3월', '4월', '5월', '6월'],
    datasets: [
        {
            label: 'Dataset 1',
            data: chart6_data1,
            borderColor: '#FFB1C1',
            backgroundColor: '#FFB1C1',
        },
        {
            label: 'Dataset 2',
            data: chart6_data2,
            borderColor: '#FFCF9F',
            backgroundColor: '#FFCF9F',
        }
    ]
};

const chart6_config = {
    type: 'bubble',
    data: chart6_data,
    options: {
        responsive: true,
        plugins: {
            legend: {
                position: 'top',
            },
            title: {
                display: true,
                text: 'Chart.js Bubble Chart'
            }
        }
    },
};

const chart6 = new Chart(document.getElementById('chart6'), chart6_config);

/* chart6 end*/

/* chart7 */
const chart7_data = {
    labels:  ['activty1', 'activty2', 'activty3', 'activty4', 'activty5', 'activty6'],
    datasets: [
        {
            label: '계획',
            data: [50,20,30,40,50,60,70,80,60],
            borderColor: '#DBF2F2',
            backgroundColor: '#DBF2F2',
            fill: false,
        },
        {
            label: '실적',
            data: [40,18,20,40,48,53,66,60,32],
            borderColor: '#EBE0FF',
            backgroundColor: '#EBE0FF',
            fill: false,
        }
    ]
};

const chart7_config = {
    type: 'bar',
    data: chart7_data,
    options: {
      indexAxis: 'y',
      // Elements options apply to all of the options unless overridden in a dataset
      // In this case, we are setting the border of each horizontal bar to be 2px wide
      elements: {
        bar: {
          borderWidth: 2,
        }
      },
      responsive: true,
      plugins: {
        legend: {
          position: 'right',
        },
        title: {
          display: true,
          text: 'Chart.js Horizontal Bar Chart'
        }
      }
    },
  };

  const chart7 = new Chart(document.getElementById('chart7'), chart7_config);
/* chart7 end*/