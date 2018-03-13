<!DOCTYPE html>
<html>
<head>
   <link rel="stylesheet" type="text/css"
   href="css/NavBar.css">
   <link rel="stylesheet" type="text/css"
   href="css/projects5.css">
   <script type="text/javascript" src="js/filter.js"></script>
</head>
<body>
      <header class="header">
         <nav >
            <a href="homePage1.html" title="logo" class="logo">
               <img class="logo" src="logo/logo.png">
            </a>
         <ul class="links">

            <li class="navBar">
               <a href="homePage1.html" title="Home" >
                  <text>Home</text>
               </a>
            </li>
            <li class="navBar">
               <a href="projects.html" title="Projects" class="active">
                  <text>Projects</text>
               </a>
            </li>
            <li class="navBar">
               <a href="resume.html" title="Resume">
                  <text>Resume</text>
               </a>
            </li>
            <li class="navBar">
               <a href="about.html" title="About">
                  <text>About</text>
               </a>
            </li>
         </ul>
         </nav>
   </header>
   <div class="main">
      <h2>Projects</h2>
      <div class="projectDisplay">
         <div class="selectionBar">
            <h4 id="filters">Filters</h4> <br>
            Type of Project <br>
            <input  type="checkbox" id = "class"> Class projects <br>
            <input type="checkbox" id = "personal"> Personal projects <br>
            Language <br>
            <input type="checkbox" id = "C++"> C++ <br>
            <input type="checkbox" id = "Java"> Java <br>
            <button class="button" id = "applyButton" onclick="filterButton()">Apply</button>
            <button class="button" id = "resetButton" onclick="resetFilter()">Reset Filters</button>
         </div>
         <div class = "projectInformation" id="demo">
            <?php
               $title = array();
               $type = array();
               $language = array();
               $x = 0;
               $description = array();
               $mysqli = new mysqli("localhost", "root", "soccerman73", "personalwebsite");
               if($mysqli->connect_error)
                  die("Connection failed: " . $mysqli->connect_error);
               $result = $mysqli->query("SELECT * FROM projects");
               while($row = $result->fetch_assoc())
               {
                  $title[$x] = $row["title"];
                  $description[$x] = $row["description"];
                  $type[$x] = $row["type"];
                  $language[$x] = $row["language"];
                  $x++;
               }
               $i = 0;
               echo "<div id = number> $x </div>";
               for($i = 0; $i < $x; $i++)
               {
                  echo "<div class = \"pro\" id = \"project$i\" >
                        <h3 class = \"projectTitle\" id = \"projectTitle$i\"> $title[$i] </h3>
                        <text class = \"type\">Type:</text> <text id = \"type$i\">$type[$i]</text>
                        <br>
                        <text class = \"language\">Language:</text> <text id = \"language$i\">$language[$i]</text>
                        <br>
                        $description[$i]
                        <br>
                        </div>";
               }

             ?>
             <div id = "js"></div>


         </div>
      </div>

   </div>
   <script>
      function filter(id, type, language){
         this.id = id;
         this.type = type;
         this.language = language;
         this.size += 1;
      }

      function resetFilter(){
         location.reload();
      }

      function filterButton() {
         var num = document.getElementById('number').innerHTML;
         var type = [];
         var filterType = ["class", "personal", "C++", "Java"];
         var language = [];
         var id = [];
         var f = [];
         for(var i = 0; i < num; i++)
         {
            type = document.getElementById("type" + i).innerHTML;
            language = document.getElementById("language" + i).innerHTML ;
            id[i] = "project" + i;
            f[i] = new filter(id, type, language);
         }
         var checked;
         for(var j = 0; j < 4; j++)
         {
            checked = document.getElementById(filterType[j]).checked;
            for(var i = 0; i <= num; i++)
            {
               if((!checked && (filterType[j] == f[i].type)) || (!checked && (filterType[j] == f[i].language))) {
                  document.getElementById(id[i]).style.display="none";
               }
            }
         }
      }

   </script>

</body>
</html>
