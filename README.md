# jfx-CYK <img src="src/ui/iconexe.png" width="40" height="40"/>

## About the project🚀
It is a program that from a context-independent grammar G and a string w establishes whether the grammar generates that string, i.e. w ∈ L(G).

Our implementation is based on the following pseudocode of the CYK algorithm:
* **ENTRADA:**
    Gramática G en FNC y cadena de n terminales w = a1,a2, ... ,an.<br>
* **INICIALIZAR:**<br>
    j = 1. Para cada i, 1 <= i <= n;<br>
    Xij = Xi1 := conjunto de variables A tales que A → ai<br>
* **REPETIR:**<br>
    j := j + 1. Para cada i, 1 <= i <= n - j + 1;<br>
            Xij := conjunto de variables A tales que A → BC es<br>
            Xij = Xi1 := conjunto de variables A tales que A → ai<br>
            una producción de G, con B ∈ Xik y C ∈ Xi+k,j-k, <br>
            considerando todos los k tales que 1 <= k <= j - 1.<br>
* **HASTA:** j = n.<br>
* **SALIDA:** w ∈ L(G) si y sólo si S ∈ X1n.<br>

## Installation and execution🔧💻
* To run the program you need a minimum JRE of: "jre1.8.0_281".
* Our program is portable:<br>
 1️⃣ You can clone this repository and then compile it in your console,<br>
 2️⃣ You can download a .ZIP file of our project and then unzip this folder to compile it in your console, or <br> 
 3️⃣ You can look for the runnable .jar file, following this steps:<br>
      * Browse to the directory in which you unzipped the .ZIP file or jfx-CYK folder if you cloned our repository.<br> 
      * Browse to the executable folder.<br> 
      * Double clic on CYK-algorithm.jar<br>
    
## Build with 🛠️
* [Eclipse](https://www.eclipse.org/downloads/) - IDE utilized.
* [Java](https://www.oracle.com/co/java/technologies/javase/javase-jdk8-downloads.html) - Programming language implemented.
* [Scene Builder](https://gluonhq.com/products/scene-builder/) - Design tool used in the construction of the graphical interface.

## How to use the program? 📌
You can find an **instructions manual** [here](https://github.com/AngelicaCorrales/jfx-CYK/blob/main/docs/Manual%20de%20instrucciones%20del%20programa%20jfx-CYK.pdf)!!

## Authors ✒️
* **Angélica Corrales Quevedo** - [AngelicaCorrales](https://github.com/AngelicaCorrales).
* **Keren López Córdoba** - [KerenLopez](https://github.com/KerenLopez).

