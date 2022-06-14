## jqGrid option
```
$("#mainGrid").jqGrid({ 
   url : "/board/searchData.do", // ajax 처럼 데이터를 주고받을 서버 url 주소이다. 
   datatype : "JSON", // local, xml, xmlstring, json, jsonstring, javascript 등의 데이터 타입 기재 
   postData : { // ajax와 마찬가지로 넘겨줄 데이터 
   "key1" : value1 
   "key2" : value2 
   ... 
   }, 
   mtype : "POST", // POST or GET 형식 선택 
   colNames : searchResultColNames, // 그리드 헤더의 제목 배열 (colModel 개수와 맞아야함) 
   colModel : searchResultColModel,// 그리드 행 데이터 (꼭 컬럼(VO)과 매칭을 시켜줘야하며 colName 개수와 일치) 
   rowNum : 10, // 보여줄 행의 개수 설정 
   rowList : [10,20,30], // 한 화면에 보여줄 row의 수(rowNum의 수) 를 조절 가능하도록 기능 제공 
   pager : "#pager", // 일반적으로 페이징 처리할 태그의 id 값을 넣어줌 (대부분 pager로 통일함) 
   height : 261, // 그리드 높이 설정 
   width : 1019, // 그리드 넓이 설정 (auto 설정가능) 
   autowidth : true, // width 속성과 동시 사용 불가 
   sortname : "bbsDate", // 처음 그리드를 불러올 때 정렬에 사용할 기준 컬럼 
   sortorder : "desc", // 정렬 기준 
   sortable : true, // colmodel 에기능을 사용하려 true 설정
   multiselect : true, // 그리드 왼쪽부분에 셀렉트 박스가 생겨 다중선택이 가능해진다. 
   emptyrecode : "작성된 글이 없습니다.", // 뿌려줄 데이터가 없을 경우 보여줄 문자열 지정 
   rownumber : true, // 각 row의 맨 앞줄에 각 행의 번호가 자동으로 부여 되도록 설정
   cellEdit : false, // 셀 편집 여부 true 설정시 onSelectRow 이벤트를 사용할 수 없으며 마우스 hover를 사용할 수 없다.
   shrinkToFit : true, // width부분 조정해주는 옵션, true일 경우 width가 자동으로 조정됨
   gridview : true, // 데이터 읽어들이는 속도 향상 단, treeGrid, subGrid와 afterInsertRow 이벤트를 사용할 수 없다.
});
```
|옵션|설명|
|:---:|:---|
|url | ajax 처럼 데이터를 주고받을 서버 url 주소|
|datatype | 데이터의 타입 ( ajax처럼 사용, local 타입도 존재 )|
|postData | 넘겨줄 데이터|
|mtype | POST or GET|
|colNames | 그리드 헤더의 제목 배열 ( colModel 과 개수가 꼭 맞아야함 )|
|colModel | 그리드 행에 보여줄 데이터 (colNames 의 개수와 맞아야 함)|
|rowNum | 보여줄 행의 개수|
|pager | 페이징을 하기 위해 선언해두며 거의 필수 |
|height , width | 높이 , 넓이|
|caption | 타이틀 , 제목|
</br>

## colmodel option
|옵션|설명|
|:---:|:---|
|name | 해당 column 에 출력해야할 데이터의 이름 ( 서버로부터 넘어오는 데이터명을 명시 )|
|index | 데이터 출력과는 연관이 없으며 정렬에 사용할 때 서버로 전송 시 넘어가는 데이터명|
|width | column 의 가로 사이즈|
|align  | column 내에서의 데이터 정렬 ( left, right, center 등 )|
|sortable | 해당 컬럼이 정렬될수 있는지를 지정 ( 일반적으로 true 설정이며 특정 컬럼의 정렬을 허용하지 않을때 사용함 )|
|hidden | 특정 컬럼의 내용을 보이지 않게 하기 위해 설정|
|format | intefer, number, currency, data 등의 컬럼 데이터의 format을 설정하기 위해 사용|
|label | colNames 가 비어있을 때 컬럼의 제목을 정의 ( colName 배열과 label 속성이 없을 경우 name으로 대체함 )|
|edittype | 편집가능한 필드 타입을 정의하며 사용함 ( text, textarea, select, checkbox, password, button, image, file, custom 타입을 정의할 수 있으며 기본값은 'text' ) |
</br>

## jqGrid event option
```
loadError : function(xhr, status, error){ // 불러오기 실패했을 경우 발생하는 이벤트 
   // xhr : XMLHttpRequest object , status : type of error , error : exception object 
}, 
```
```
onSelectRow : function(rowid, status, e){ //row를 선택했을 때 발생하는 이벤트 
   // rowid: id of the row , status : status of the selection , e: event object 
}, 
```
```
beforeRequest : function(){ // 서버로 데이터를 요청하기 직전에 발생하는 이벤트 
   // 
}, 
```
```
gridComplete : function(){ // 그리드가 완전히 모든 작업을 완료한 후 발생하는 이벤트 
   // 
}, 
```
```
loadComplete : function(){ // 서버에 요청을 보낸 직후 바로 발생하는 이벤트 
   // 
}, 
```
```
onPaging : function(pgButton){ // 페이징이 변경되는 경우에 발생하는 이벤트 
   // pgButton : [page button] and also page number in the page input box (press Enter) , etc 
},
``` 
```
onRightClickRow : function(rowid, iRow, iCol, e){ // 마우스 우클릭 했을경우 발생하는 이벤트 
   // rowid : id of the row , iRow : index of the row , iCol : index of the cell , e : event object 
},
```
```
 onSelectAll : function(aRowids, status){ // 체크박스를 눌러 모든 row를 선택할 경우 발생하는 이벤트 (multiselection 옵션 활성화 필수) 
   // aRowids : array of the selected rowid's
   // status : header check box return true or false (true if checked, false if not checked) 
 }, 
 ```
 ```
 onCellSelect : function(rowid, iCol, cellcontent, e){// cell 즉 column 선택을 처리하기위해 사용되는 이벤트 (cell 식별 시 사용) 
   // rowid : id of the row , iCol : index of the cell
   // cellcontent : content of the cell , e : event object 
 },
```
```
 afterEditCell : function(rowid, cellname, value, iRow, iCol){// 편집 가능한 셀에만 적용, 편집 후 발생하는 이벤트
   // rowid : id of the row , iCol : index of the cell 
 },
```
```
 afterSaveCell : function(rowid, name, value, iRow, iCol){// 편집 가능한 셀에만 적용, 셀이 성공적으로 저장된 후 발생하는 이벤트
   // rowid : id of the row , iCol : index of the cell 
 },
```
