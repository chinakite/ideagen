<html>
	<head>
		<title>${projectName}</title>
		<link href="/${projectName}/style/jqModal.css" rel="stylesheet" type="text/css" >
		
		<script type="text/javascript" src="/${projectName}/js/jquery-1.7.2.min.js"></script>
		<script type="text/javascript" src="/${projectName}/js/jquery.idea-commons.0.1.js"></script>
		<script type="text/javascript" src="/${projectName}/js/jqModal.js"></script>
	</head>
	<body>
		<input type="button" value="Test Exception" onclick="testException()"/>
		<div id="exceptionWindow" style="width:600px;height:400px;overflow-y:auto;" class="jqmWindow">
		
		</div>
		<script type="text/javascript">
			$(document).ready(function(){
				$('#exceptionWindow').jqm({modal:true});
			});
		
			function testException() {
				$.get(
					'/ideadp/exception',
					{},
					function(data) {
						var obj = parseJSON(data);
						if(obj) {
							alert('haha');
						}
					}
				);
			}
		</script>
	</body>
</html>