import 'package:firebase_core/firebase_core.dart';
import 'package:flutter/foundation.dart';

Future initFirebase() async {
  if (kIsWeb) {
    await Firebase.initializeApp(
        options: FirebaseOptions(
            apiKey: "AIzaSyBZBWSiUuV0rWZcuhUdgy57OBKPMC4oNUs",
            authDomain: "traqueno-a1584.firebaseapp.com",
            projectId: "traqueno-a1584",
            storageBucket: "traqueno-a1584.appspot.com",
            messagingSenderId: "49740925008",
            appId: "1:49740925008:web:43170e2ba669ef54652955",
            measurementId: "G-2KQMV2S7N6"));
  } else {
    await Firebase.initializeApp();
  }
}
