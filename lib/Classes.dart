import 'dart:convert';
import 'dart:developer';

import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;

class Classe extends StatefulWidget {
  @override
  _ClasseState createState() => _ClasseState();
}

class _ClasseState extends State<Classe> {
  List<dynamic>? listClasses;
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Classes'),
      ),
      body: Center(
          child: this.listClasses == null
              ? CircularProgressIndicator()
              : ListView.builder(
                  itemCount:
                      (this.listClasses == null) ? 0 : listClasses!.length,
                  itemBuilder: (context, index) {
                    return Card(
                      color: Colors.purple,
                      child: RaisedButton(
                        child: Text(listClasses![index]['nomClass']),
                        onPressed: () {},
                      ),
                    );
                  })),
    );
  }

  @override
  void initState() {
    super.initState();
    log("Loading classe");
    loadClasse();
  }

  void loadClasse() {
    String url = "http://192.168.56.1:8080/classes";
    http.get(Uri.parse(url)).then((resp) {
      //faite attnetion à se niveau là
      // risque d'erreur
      log(resp.body.toString());
      log(json.decode(resp.body)['_embedded']['classes']);
      setState(() {
        this.listClasses = json.decode(resp.body)['_embedded']['classes'];
      });
    }).catchError((err) {
      log(err.toString());
    });
  }
}
