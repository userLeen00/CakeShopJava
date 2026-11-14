# Cake Shop Ordering System

A cake-ordering application written in Java and implemented **three ways** to compare programming paradigms on the same problem. Built for the Java Programming course at Al Hussein Technical University (HTU), Spring 2025.

## Overview

A customer browses a cake menu sorted by price, adds items to an order, and receives a total. Orders over 15 JD receive a 10% discount in the console versions.

| Version | Package | Approach | Interface |
|---|---|---|---|
| Procedural | `proceduralCode` | Static methods and parallel arrays | Console (simulated input) |
| Object-Oriented | `oopCode` | `Cake` / `SaucedCake` class hierarchy, `ManageCakeShop` | Console (`Scanner`) |
| Event-Driven | `javaEvents` | Java Swing with event listeners | Graphical (two windows) |
| Event-Driven (extended) | `eventDriven` | Swing version with customer name, per-cake quantity fields and Visa/Cash checkbox | Graphical |

## Features

- **Selection Sort** to order the menu by price (implemented in each version)
- **Discount logic**: 10% off when the total exceeds 15 JD
- **OOP concepts**: encapsulation (private fields, getters/setters), inheritance (`SaucedCake extends Cake`), polymorphism (overridden `toString`), constructor overloading
- **Event handling** (Swing): key, mouse, mouse-motion and action listeners; double-click to start; Visa/Cash payment checkbox; input validation with `try/catch` and dialog messages; receipt dialog

## Project structure

```
src/
├── proceduralCode/   CakeShopProcedural.java
├── oopCode/          Cake.java, SaucedCake.java, ManageCakeShop.java, CakeShopOOP.java
├── javaEvents/       CakeShopED.java
└── eventDriven/      EventDriven.java (extended version), Test.java (earlier prototype)
```

## Run

Requires JDK 11 or later.

```bash
javac -d out src/proceduralCode/*.java src/oopCode/*.java src/javaEvents/*.java src/eventDriven/*.java

java -cp out proceduralCode.CakeShopProcedural
java -cp out oopCode.CakeShopOOP
java -cp out javaEvents.CakeShopED
java -cp out eventDriven.EventDriven
```

## Tech

Java, Swing (AWT events), Eclipse IDE

## Author

Leen Shannak - Computer Science student, HTU
