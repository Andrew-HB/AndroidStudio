package com.example.labwork_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlin.math.sqrt

data class Figure (
    var width: Int,
    var height: Int
) {
    val area: Int
        get() = this.width * this.height
}

sealed interface Shape {
    class Rectangle(var width: Int, var height: Int) : Shape {
        val area: Int
            get() = this.width * this.height
    }

    class Oval(var radius: Int) : Shape {
        val area: Double
            get() = 2 * 3.1415 * this.radius
    }

    class Line(var x1: Int, var y1: Int, var x2: Int, var y2: Int) : Shape {
        val length: Double
            get() = sqrt((this.x2 - this.x1) * (this.x2 - this.x1) + (this.y2 - this.y1) * (this.y2 - this.y1) as Double)
    }
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*
        Потренуватися створювати data класи, enum та sealed класи.
        Наприклад, це може бути data class Figure з полями width, height та полем area в самому класі.
        Також зробити приватний сеттер для поля area,
        а геттер має вертати результат множення width*height.
        Створити список із дата класів Figure. В циклі порахувати загальну суму полів area.

        Створити sealed клас Shape та його наслідників Rectangle, Oval, Line.
        Далі створити список з екземплярів тих класів. Порахувати кількість Rectangle, Oval та Line.
        Потренуватися зробити це двома варіантами:
        за допомогою фільтрації списку та з використанням when в циклі списку.

        Не створювати зайвих змінних для підрахунку кількості різних типів Shape
        (Через одну змінну або структуру або набір операторів)
        */
        val square = Figure(10, 10)
        val list = arrayOf(Figure(10,10), Figure(15,15), Figure(1,1))

        var areaSum: Int = 0
        for (item in list) {
            areaSum += item.area
        }

        println("______________________________________________________________")
        println("Sum of areas of ${list.size} items is ${areaSum}!")
        println("______________________________________________________________")

        val shapeList = mutableListOf<Shape>()
        shapeList.add(Shape.Rectangle(10, 20))
        shapeList.add(Shape.Oval(10))
        shapeList.add(Shape.Line(1, 1, 5, 5))

        shapeList.add(Shape.Line(1, 1, 5, 5))
        shapeList.add(Shape.Oval(10))
        shapeList.add(Shape.Rectangle(10, 20))

        shapeList.add(Shape.Rectangle(10, 20))
        shapeList.add(Shape.Line(1, 1, 5, 5))

        shapeList.add(Shape.Rectangle(10, 20))
        shapeList.add(Shape.Oval(10))

        var rectangles = shapeList.filterIsInstance<Shape.Rectangle>().count()
        var ovals = shapeList.filterIsInstance<Shape.Oval>().count()
        var lines = shapeList.filterIsInstance<Shape.Line>().count()

        println("______________________________________________________________")
        println("FILTER: Number of Rectangles: ${rectangles}")
        println("FILTER: Number of Ovals: ${ovals}")
        println("FILTER: Number of Lines: ${lines}")
        println("______________________________________________________________")

        rectangles = 0
        ovals = 0
        lines = 0

        for (item in shapeList) {
            when (item) {
                is Shape.Rectangle -> rectangles++
                is Shape.Oval -> ovals++
                is Shape.Line -> lines++
            }
        }

        println("______________________________________________________________")
        println("WHEN: Number of Rectangles: ${rectangles}")
        println("WHEN: Number of Ovals: ${ovals}")
        println("WHEN: Number of Lines: ${lines}")
        println("______________________________________________________________")
    }
}