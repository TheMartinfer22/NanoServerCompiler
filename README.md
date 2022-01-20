## NanoServerCompiler 

#### ⛏ This a project with a objetive to automatize maven compiler and make easy debug server (Bukkit Dev's).

* How this work?
  1. Looks for a server jar in the folder, if it doesn't find it it will download.
  2. Is Asked for folder project, maven compile command and plugin jar name (into **target** folder on output).
  3. Compile using maven command and move jar to plugins folder (replace if already exist).
  4. Done.
