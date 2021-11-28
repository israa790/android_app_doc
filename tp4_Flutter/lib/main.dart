import 'dart:convert';

import 'package:flutter/material.dart';

import './pizza.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter JSON Demo',
      theme: ThemeData(
        primarySwatch: Colors.blue,
        visualDensity: VisualDensity.adaptivePlatformDensity,
      ),
      home: MyHomePage(),
    );
  }
}

class MyHomePage extends StatefulWidget {
  @override
  _MyHomePageState createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  String pizzaString = '';
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('JSON')),
      body: Container(
        child: Text(pizzaString),
      ),
    );
  }

  Future readJsonFile() async {
    String myString = await DefaultAssetBundle.of(context)
        .loadString('assets/pizzalist.json');
    List myMap = jsonDecode(myString);
    List<Pizza> myPizzas = [];
    myMap.forEach((dynamic pizza) {
      Pizza myPizza = Pizza.fromJson(pizza);
      myPizzas.add(myPizza);
    });
    setState(() {
      pizzaString = myString;
    });
  }

  @override
  void initState() {
    readJsonFile();
    super.initState();
  }
}
