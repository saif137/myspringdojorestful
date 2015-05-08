<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>
	Welcome to Dojo and REST Web Service Applications Demo Site
</title>

<script src="dojo/dojo.js"></script>

<link rel="stylesheet" href="style.css" media="screen">
<link rel="stylesheet" href="demo.css" media="screen">
<!--  link rel="stylesheet" href="dijit/themes/claro/claro.css" media="screen" -->
<!--  link rel="stylesheet" href="dijit/themes/nihilo/nihilo.css" media="screen" -->
<link rel="stylesheet" href="dijit/themes/soria/soria.css" media="screen">
<!--  link rel="stylesheet" href="dijit/themes/tundra/tundra.css" media="screen" -->
</head>
<body class="soria">

<div class="demoLayout" style="height: 786px; width: 1024px" data-dojo-type="dijit.layout.BorderContainer" data-dojo-props="design: 'headline'">
			<div class="demoLayout" style="height: 13%" data-dojo-type="dijit.layout.BorderContainer" data-dojo-props="region: 'top', splitter: true, design: 'headline'">
				<div align="center" class="centerPanel" data-dojo-type="dijit.layout.ContentPane" data-dojo-props="region: 'center'">
					<h1>Welcome to Dojo and REST Web Service Applications Demo Site</h1>
					<p>You can make use of Dojo Toolkit and REST Web Service on this web site</p>
				</div>
			</div>
			<div class="centerPanel" style="height: 75%; width: 100%" data-dojo-type="dijit.layout.ContentPane" data-dojo-props="region: 'center'">
				<div class="centerPanel" data-dojo-type="dijit.layout.TabContainer" data-dojo-props="region: 'center', tabPosition: 'top'" style="width: 600px;">
					<div data-dojo-type="dijit.layout.ContentPane" title="Demo User Information">
						<h4>User Information REST Web Service Demo</h4>
						<a href="clientdojo.jsp">
						Click here for user information
						</a>
					</div>
				</div>
			</div>
			<!--  div class="edgePanel" data-dojo-type="dijit.layout.ContentPane" data-dojo-props="splitter: true, region: 'left'">left</div -->
			<!-- div class="demoLayout" style="width: 70%" data-dojo-type="dijit.layout.BorderContainer" data-dojo-props="region: 'right', design: 'headline'">
				<div class="centerPanel" data-dojo-type="dijit.layout.ContentPane" data-dojo-props="region: 'center'">center</div>
				<!-- div class="edgePanel" data-dojo-type="dijit.layout.ContentPane" data-dojo-props="region: 'left'">left</div>
			</div -->
			<div class="edgePanel"  style="height: 10%" data-dojo-type="dijit.layout.ContentPane" data-dojo-props="splitter: true, region: 'bottom'">
			This region will be used to report any progress
			</div>
</div>

<!-- div id="appLayout"  style="height: 1024px; width: 768px" class="demoLayout" data-dojo-type="dijit.layout.BorderContainer" data-dojo-props="design: 'headline'">
	<div id="appLayout" class="demoLayout" data-dojo-type="dijit.layout.BorderContainer" data-dojo-props="design: 'headline' region: 'top'">	
		<div id="leftCol" class="edgePanel" data-dojo-type="dijit.layout.ContentPane" data-dojo-props="region: 'left', splitter: true" style="width: 200px;">
				I will put menu here
		</div>
		<div id="rightCol" class="edgePanel" data-dojo-type="dijit.layout.ContentPane" data-dojo-props="region: 'right', splitter: true" style="width: 200px;">
				I will put notifications here
		</div>
	 </div>
	<div class="centerPanel" data-dojo-type="dijit.layout.TabContainer" data-dojo-props="region: 'center', tabPosition: 'top'" style="width: 600px;">
		<div data-dojo-type="dijit.layout.ContentPane" title="Demo User Information">
			<h4>User Information REST Web Service Demo</h4>
		</div>
	</div>
</div -->

	<script>
	require(["dojo/parser"
	         , "dijit/layout/BorderContainer"
	         , "dijit/layout/TabContainer"
	         , "dijit/layout/ContentPane"
	         , "dijit/form/Button"
	         , "dijit/form/DropDownButton"
	         , "dijit/TooltipDialog"
	         , "dijit/form/TextBox"
	         , "dojo/domReady!"], 
	function(parser){
		parser.parse();
	});
	</script>
</body>
</html>