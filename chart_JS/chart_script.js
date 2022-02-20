
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