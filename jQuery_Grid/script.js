let searchResultColNames = ['게시글관리번호', '번호', '제목', '작성자', '날짜'];
let searchResultColModel = [
   { name: 'bbsMgtNo', index: 'bbsMgtNo', align: 'center', hidden: true },
   { name: 'bbsNum', index: 'bbsNum', align: 'left', width: '12%' },
   { name: 'bbsTitle', index: 'bbsTitle', align: 'center', width: '50%' },
   { name: 'bbsWriter', index: 'bbsWriter', align: 'center', width: '14%' },
   { name: 'bbsDate', index: 'bbsDate', align: 'center', width: '12%' },
];

let ex_data = [
   { bbsMgtNo: "1", bbsNum: "1", bbsTitle: "title1", bbsWriter: "john", bbsDate: "2022-05-04" },
   { bbsMgtNo: "2", bbsNum: "2", bbsTitle: "title2", bbsWriter: "jason", bbsDate: "2022-05-04" },
   { bbsMgtNo: "3", bbsNum: "3", bbsTitle: "title3", bbsWriter: "tom", bbsDate: "2022-05-03" },
   { bbsMgtNo: "4", bbsNum: "4", bbsTitle: "title4", bbsWriter: "tim", bbsDate: "2022-05-01" },
   { bbsMgtNo: "5", bbsNum: "5", bbsTitle: "title5", bbsWriter: "john", bbsDate: "2022-05-04" },
   { bbsMgtNo: "6", bbsNum: "6", bbsTitle: "title6", bbsWriter: "son", bbsDate: "2022-05-01" },
   { bbsMgtNo: "7", bbsNum: "7", bbsTitle: "title7", bbsWriter: "sena", bbsDate: "2022-05-02" },
   { bbsMgtNo: "8", bbsNum: "8", bbsTitle: "title8", bbsWriter: "tommy", bbsDate: "2022-05-04" },
   { bbsMgtNo: "9", bbsNum: "9", bbsTitle: "title9", bbsWriter: "jack", bbsDate: "2022-05-02" },
   { bbsMgtNo: "10", bbsNum: "10", bbsTitle: "title10", bbsWriter: "tim", bbsDate: "2022-05-03" },
   { bbsMgtNo: "11", bbsNum: "11", bbsTitle: "title11", bbsWriter: "jenny", bbsDate: "2022-05-04" },
];

$(function () {
   $("#mainGrid").jqGrid({
      datatype: "local",
      data: ex_data,
      height: 261,
      width: 1019,
      colNames: searchResultColNames,
      colModel: searchResultColModel,
      rowNum: 10,
      pager: "pager"
   });
});