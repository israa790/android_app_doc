import 'dart:convert';

import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:http/http.dart' as http;

import 'Dashboard.dart';
import 'User.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Form with validation App',
      debugShowCheckedModeBanner: false,
      theme: ThemeData(
        primarySwatch: Colors.cyan,
      ),
      home: Register(),
    );
  }
}

class Register extends StatefulWidget {
  Register({Key? key}) : super(key: key);
  @override
  _RegisterState createState() => _RegisterState();
}

class _RegisterState extends State<Register> {
  final _formKey = GlobalKey<FormState>();
  User user = User("", "");
  String url = "http://192.168.1.105:8080/register";

  Future save() async {
    var res = await http.post(Uri.parse(url),
        headers: {'Content-Type': 'application/json'},
        body: json.encode({'email': user.email, 'password': user.password}));
    print(res.body);
    if (res.body != null) {
      Navigator.push(
          context,
          MaterialPageRoute(
            builder: (context) => Dashboard(),
          ));
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        body: Center(
            child: SingleChildScrollView(
                child: Form(
                    key: _formKey,
                    child: Column(
                        mainAxisAlignment: MainAxisAlignment.center,
                        crossAxisAlignment: CrossAxisAlignment.center,
                        children: <Widget>[
                          Container(
                            height: 520.0,
                            width: 340.0,
                            child: Padding(
                              padding: const EdgeInsets.all(10),
                              child: Column(
                                children: [
                                  Text(
                                    "Register",
                                    style: GoogleFonts.oswald(fontSize: 30),
                                  ),
                                  SizedBox(
                                    height: 30,
                                  ),
                                  TextFormField(
                                    controller:
                                        TextEditingController(text: user.email),
                                    decoration: InputDecoration(
                                      hintText: "Your email...",
                                      border: OutlineInputBorder(),
                                    ),
                                  ),
                                  SizedBox(
                                    height: 30,
                                  ),
                                  TextFormField(
                                    obscureText: true,
                                    controller: TextEditingController(
                                        text: user.password),
                                    decoration: InputDecoration(
                                      hintText: "Your password...",
                                      border: OutlineInputBorder(),
                                    ),
                                  )
                                ],
                              ),
                            ),
                          ),
                          Container(
                            child: TextButton(
                              onPressed: () {
                                if (_formKey.currentState == null) return;
                                if (_formKey.currentState!.validate()) {
                                  save();
                                }
                              },
                              child: Icon(Icons.arrow_forward),
                            ),
                          )
                        ])))));
  }
}
