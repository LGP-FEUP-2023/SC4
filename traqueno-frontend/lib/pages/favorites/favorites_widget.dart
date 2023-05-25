import '/flutter_flow/flutter_flow_icon_button.dart';
import '/flutter_flow/flutter_flow_theme.dart';
import '/flutter_flow/flutter_flow_util.dart';
import '/flutter_flow/flutter_flow_widgets.dart';
import 'package:flutter/material.dart';
import 'package:flutter_spinkit/flutter_spinkit.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:provider/provider.dart';
import 'favorites_model.dart';
export 'favorites_model.dart';

class FavoritesWidget extends StatefulWidget {
  const FavoritesWidget({Key? key}) : super(key: key);

  @override
  _FavoritesWidgetState createState() => _FavoritesWidgetState();
}

class _FavoritesWidgetState extends State<FavoritesWidget> {
  late FavoritesModel _model;

  final scaffoldKey = GlobalKey<ScaffoldState>();

  @override
  void initState() {
    super.initState();
    _model = createModel(context, () => FavoritesModel());

    WidgetsBinding.instance.addPostFrameCallback((_) => setState(() {}));
  }

  @override
  void dispose() {
    _model.dispose();

    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    context.watch<FFAppState>();

    return Scaffold(
      key: scaffoldKey,
      backgroundColor: FlutterFlowTheme.of(context).primaryBackground,
      appBar: AppBar(
        backgroundColor: Color(0xFFFF0000),
        automaticallyImplyLeading: false,
        leading: FlutterFlowIconButton(
          borderColor: Colors.transparent,
          borderRadius: 30.0,
          borderWidth: 1.0,
          buttonSize: 60.0,
          icon: Icon(
            Icons.arrow_back_rounded,
            color: Colors.white,
            size: 30.0,
          ),
          onPressed: () async {
            context.pop();
          },
        ),
        title: Text(
          'Favorites',
          style: FlutterFlowTheme.of(context).headlineMedium.override(
                fontFamily: 'Ubuntu',
                color: Colors.white,
                fontSize: 22.0,
              ),
        ),
        actions: [],
        centerTitle: true,
        elevation: 2.0,
      ),
      body: Stack(
        children: [
          Column(
            mainAxisSize: MainAxisSize.max,
            children: [
              Expanded(
                child: SingleChildScrollView(
                  child: Column(
                    mainAxisSize: MainAxisSize.max,
                    children: [
                      Padding(
                        padding:
                            EdgeInsetsDirectional.fromSTEB(0.0, 0.0, 0.0, 1.0),
                        child: Container(
                          width: double.infinity,
                          height: 90.0,
                          decoration: BoxDecoration(
                            color: FlutterFlowTheme.of(context)
                                .secondaryBackground,
                          ),
                          child: Row(
                            mainAxisSize: MainAxisSize.max,
                            children: [
                              Column(
                                mainAxisSize: MainAxisSize.max,
                                children: [
                                  Padding(
                                    padding: EdgeInsetsDirectional.fromSTEB(
                                        8.0, 8.0, 8.0, 8.0),
                                    child: ClipRRect(
                                      borderRadius: BorderRadius.circular(8.0),
                                      child: Image.network(
                                        'https://images.unsplash.com/photo-1441986300917-64674bd600d8?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8c3RvcmV8ZW58MHx8MHx8&auto=format&fit=crop&w=800&q=60',
                                        width: 74.0,
                                        height: 74.0,
                                        fit: BoxFit.cover,
                                      ),
                                    ),
                                  ),
                                ],
                              ),
                              Expanded(
                                child: Padding(
                                  padding: EdgeInsetsDirectional.fromSTEB(
                                      8.0, 1.0, 0.0, 0.0),
                                  child: Column(
                                    mainAxisSize: MainAxisSize.max,
                                    mainAxisAlignment: MainAxisAlignment.center,
                                    children: [
                                      Row(
                                        mainAxisSize: MainAxisSize.max,
                                        children: [
                                          Text(
                                            'Store/Location Name',
                                            style: FlutterFlowTheme.of(context)
                                                .titleSmall
                                                .override(
                                                  fontFamily: 'Ubuntu',
                                                  fontSize: 18.0,
                                                ),
                                          ),
                                        ],
                                      ),
                                      Row(
                                        mainAxisSize: MainAxisSize.max,
                                        children: [
                                          Text(
                                            '123 Address St, City, ST',
                                            style: FlutterFlowTheme.of(context)
                                                .bodySmall
                                                .override(
                                                  fontFamily: 'Ubuntu',
                                                  fontSize: 16.0,
                                                ),
                                          ),
                                        ],
                                      ),
                                      Row(
                                        mainAxisSize: MainAxisSize.max,
                                        children: [
                                          Text(
                                            '1.7 km',
                                            style: FlutterFlowTheme.of(context)
                                                .bodyMedium
                                                .override(
                                                  fontFamily: 'Ubuntu',
                                                  color: Color(0xFFFF0000),
                                                  fontSize: 16.0,
                                                  fontWeight: FontWeight.w500,
                                                ),
                                          ),
                                        ],
                                      ),
                                    ],
                                  ),
                                ),
                              ),
                              Column(
                                mainAxisSize: MainAxisSize.max,
                                children: [
                                  Expanded(
                                    child: Padding(
                                      padding: EdgeInsetsDirectional.fromSTEB(
                                          0.0, 0.0, 8.0, 0.0),
                                      child: Icon(
                                        Icons.chevron_right_outlined,
                                        color: Color(0xFF95A1AC),
                                        size: 24.0,
                                      ),
                                    ),
                                  ),
                                ],
                              ),
                            ],
                          ),
                        ),
                      ),
                      Padding(
                        padding:
                            EdgeInsetsDirectional.fromSTEB(0.0, 0.0, 0.0, 1.0),
                        child: Container(
                          width: double.infinity,
                          height: 90.0,
                          decoration: BoxDecoration(
                            color: FlutterFlowTheme.of(context)
                                .secondaryBackground,
                          ),
                          child: Row(
                            mainAxisSize: MainAxisSize.max,
                            children: [
                              Column(
                                mainAxisSize: MainAxisSize.max,
                                children: [
                                  Padding(
                                    padding: EdgeInsetsDirectional.fromSTEB(
                                        8.0, 8.0, 8.0, 8.0),
                                    child: ClipRRect(
                                      borderRadius: BorderRadius.circular(8.0),
                                      child: Image.network(
                                        'https://images.unsplash.com/photo-1556741533-6e6a62bd8b49?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8N3x8c3RvcmV8ZW58MHx8MHx8&auto=format&fit=crop&w=800&q=60',
                                        width: 74.0,
                                        height: 74.0,
                                        fit: BoxFit.cover,
                                      ),
                                    ),
                                  ),
                                ],
                              ),
                              Expanded(
                                child: Padding(
                                  padding: EdgeInsetsDirectional.fromSTEB(
                                      8.0, 1.0, 0.0, 0.0),
                                  child: Column(
                                    mainAxisSize: MainAxisSize.max,
                                    mainAxisAlignment: MainAxisAlignment.center,
                                    children: [
                                      Row(
                                        mainAxisSize: MainAxisSize.max,
                                        children: [
                                          Text(
                                            'Store/Location Name',
                                            style: FlutterFlowTheme.of(context)
                                                .titleSmall
                                                .override(
                                                  fontFamily: 'Ubuntu',
                                                  fontSize: 18.0,
                                                ),
                                          ),
                                        ],
                                      ),
                                      Row(
                                        mainAxisSize: MainAxisSize.max,
                                        children: [
                                          Text(
                                            '123 Address St, City, ST',
                                            style: FlutterFlowTheme.of(context)
                                                .bodySmall
                                                .override(
                                                  fontFamily: 'Ubuntu',
                                                  fontSize: 16.0,
                                                ),
                                          ),
                                        ],
                                      ),
                                      Row(
                                        mainAxisSize: MainAxisSize.max,
                                        children: [
                                          Text(
                                            '1.7 km',
                                            style: FlutterFlowTheme.of(context)
                                                .bodyMedium
                                                .override(
                                                  fontFamily: 'Ubuntu',
                                                  color: Color(0xFFFF0000),
                                                  fontSize: 16.0,
                                                  fontWeight: FontWeight.w500,
                                                ),
                                          ),
                                        ],
                                      ),
                                    ],
                                  ),
                                ),
                              ),
                              Column(
                                mainAxisSize: MainAxisSize.max,
                                children: [
                                  Expanded(
                                    child: Padding(
                                      padding: EdgeInsetsDirectional.fromSTEB(
                                          0.0, 0.0, 8.0, 0.0),
                                      child: Icon(
                                        Icons.chevron_right_outlined,
                                        color: Color(0xFF95A1AC),
                                        size: 24.0,
                                      ),
                                    ),
                                  ),
                                ],
                              ),
                            ],
                          ),
                        ),
                      ),
                      Padding(
                        padding:
                            EdgeInsetsDirectional.fromSTEB(0.0, 0.0, 0.0, 1.0),
                        child: Container(
                          width: double.infinity,
                          height: 90.0,
                          decoration: BoxDecoration(
                            color: FlutterFlowTheme.of(context)
                                .secondaryBackground,
                          ),
                          child: Row(
                            mainAxisSize: MainAxisSize.max,
                            children: [
                              Column(
                                mainAxisSize: MainAxisSize.max,
                                children: [
                                  Padding(
                                    padding: EdgeInsetsDirectional.fromSTEB(
                                        8.0, 8.0, 8.0, 8.0),
                                    child: ClipRRect(
                                      borderRadius: BorderRadius.circular(8.0),
                                      child: Image.network(
                                        'https://images.unsplash.com/photo-1605217613423-0a61bd725c8a?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTh8fHN0b3JlfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=800&q=60',
                                        width: 74.0,
                                        height: 74.0,
                                        fit: BoxFit.cover,
                                      ),
                                    ),
                                  ),
                                ],
                              ),
                              Expanded(
                                child: Padding(
                                  padding: EdgeInsetsDirectional.fromSTEB(
                                      8.0, 1.0, 0.0, 0.0),
                                  child: Column(
                                    mainAxisSize: MainAxisSize.max,
                                    mainAxisAlignment: MainAxisAlignment.center,
                                    children: [
                                      Row(
                                        mainAxisSize: MainAxisSize.max,
                                        children: [
                                          Text(
                                            'Store/Location Name',
                                            style: FlutterFlowTheme.of(context)
                                                .titleSmall
                                                .override(
                                                  fontFamily: 'Ubuntu',
                                                  fontSize: 18.0,
                                                ),
                                          ),
                                        ],
                                      ),
                                      Row(
                                        mainAxisSize: MainAxisSize.max,
                                        children: [
                                          Text(
                                            '123 Address St, City, ST',
                                            style: FlutterFlowTheme.of(context)
                                                .bodySmall
                                                .override(
                                                  fontFamily: 'Ubuntu',
                                                  fontSize: 16.0,
                                                ),
                                          ),
                                        ],
                                      ),
                                      Row(
                                        mainAxisSize: MainAxisSize.max,
                                        children: [
                                          Text(
                                            '1.7 km',
                                            style: FlutterFlowTheme.of(context)
                                                .bodyMedium
                                                .override(
                                                  fontFamily: 'Ubuntu',
                                                  color: Color(0xFFFF0000),
                                                  fontSize: 16.0,
                                                  fontWeight: FontWeight.w500,
                                                ),
                                          ),
                                        ],
                                      ),
                                    ],
                                  ),
                                ),
                              ),
                              Column(
                                mainAxisSize: MainAxisSize.max,
                                children: [
                                  Expanded(
                                    child: Padding(
                                      padding: EdgeInsetsDirectional.fromSTEB(
                                          0.0, 0.0, 8.0, 0.0),
                                      child: Icon(
                                        Icons.chevron_right_outlined,
                                        color: Color(0xFF95A1AC),
                                        size: 24.0,
                                      ),
                                    ),
                                  ),
                                ],
                              ),
                            ],
                          ),
                        ),
                      ),
                      Padding(
                        padding:
                            EdgeInsetsDirectional.fromSTEB(0.0, 0.0, 0.0, 1.0),
                        child: Container(
                          width: double.infinity,
                          height: 90.0,
                          decoration: BoxDecoration(
                            color: FlutterFlowTheme.of(context)
                                .secondaryBackground,
                          ),
                          child: Row(
                            mainAxisSize: MainAxisSize.max,
                            children: [
                              Column(
                                mainAxisSize: MainAxisSize.max,
                                children: [
                                  Padding(
                                    padding: EdgeInsetsDirectional.fromSTEB(
                                        8.0, 8.0, 8.0, 8.0),
                                    child: ClipRRect(
                                      borderRadius: BorderRadius.circular(8.0),
                                      child: Image.network(
                                        'https://images.unsplash.com/photo-1481437156560-3205f6a55735?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MjB8fHN0b3JlfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=800&q=60',
                                        width: 74.0,
                                        height: 74.0,
                                        fit: BoxFit.cover,
                                      ),
                                    ),
                                  ),
                                ],
                              ),
                              Expanded(
                                child: Padding(
                                  padding: EdgeInsetsDirectional.fromSTEB(
                                      8.0, 1.0, 0.0, 0.0),
                                  child: Column(
                                    mainAxisSize: MainAxisSize.max,
                                    mainAxisAlignment: MainAxisAlignment.center,
                                    children: [
                                      Row(
                                        mainAxisSize: MainAxisSize.max,
                                        children: [
                                          Text(
                                            'Store/Location Name',
                                            style: FlutterFlowTheme.of(context)
                                                .titleSmall
                                                .override(
                                                  fontFamily: 'Ubuntu',
                                                  fontSize: 18.0,
                                                ),
                                          ),
                                        ],
                                      ),
                                      Row(
                                        mainAxisSize: MainAxisSize.max,
                                        children: [
                                          Text(
                                            '123 Address St, City, ST',
                                            style: FlutterFlowTheme.of(context)
                                                .bodySmall
                                                .override(
                                                  fontFamily: 'Ubuntu',
                                                  fontSize: 16.0,
                                                ),
                                          ),
                                        ],
                                      ),
                                      Row(
                                        mainAxisSize: MainAxisSize.max,
                                        children: [
                                          Text(
                                            '1.7 km',
                                            style: FlutterFlowTheme.of(context)
                                                .bodyMedium
                                                .override(
                                                  fontFamily: 'Ubuntu',
                                                  color: Color(0xFFFF0000),
                                                  fontSize: 16.0,
                                                  fontWeight: FontWeight.w500,
                                                ),
                                          ),
                                        ],
                                      ),
                                    ],
                                  ),
                                ),
                              ),
                              Column(
                                mainAxisSize: MainAxisSize.max,
                                children: [
                                  Expanded(
                                    child: Padding(
                                      padding: EdgeInsetsDirectional.fromSTEB(
                                          0.0, 0.0, 8.0, 0.0),
                                      child: Icon(
                                        Icons.chevron_right_outlined,
                                        color: Color(0xFF95A1AC),
                                        size: 24.0,
                                      ),
                                    ),
                                  ),
                                ],
                              ),
                            ],
                          ),
                        ),
                      ),
                      Padding(
                        padding:
                            EdgeInsetsDirectional.fromSTEB(0.0, 0.0, 0.0, 1.0),
                        child: Container(
                          width: double.infinity,
                          height: 90.0,
                          decoration: BoxDecoration(
                            color: FlutterFlowTheme.of(context)
                                .secondaryBackground,
                          ),
                          child: Row(
                            mainAxisSize: MainAxisSize.max,
                            children: [
                              Column(
                                mainAxisSize: MainAxisSize.max,
                                children: [
                                  Padding(
                                    padding: EdgeInsetsDirectional.fromSTEB(
                                        8.0, 8.0, 8.0, 8.0),
                                    child: ClipRRect(
                                      borderRadius: BorderRadius.circular(8.0),
                                      child: Image.network(
                                        'https://images.unsplash.com/photo-1543996469-600fbadfc1e8?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mjh8fHN0b3JlfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=800&q=60',
                                        width: 74.0,
                                        height: 74.0,
                                        fit: BoxFit.cover,
                                      ),
                                    ),
                                  ),
                                ],
                              ),
                              Expanded(
                                child: Padding(
                                  padding: EdgeInsetsDirectional.fromSTEB(
                                      8.0, 1.0, 0.0, 0.0),
                                  child: Column(
                                    mainAxisSize: MainAxisSize.max,
                                    mainAxisAlignment: MainAxisAlignment.center,
                                    children: [
                                      Row(
                                        mainAxisSize: MainAxisSize.max,
                                        children: [
                                          Text(
                                            'Store/Location Name',
                                            style: FlutterFlowTheme.of(context)
                                                .titleSmall
                                                .override(
                                                  fontFamily: 'Ubuntu',
                                                  fontSize: 18.0,
                                                ),
                                          ),
                                        ],
                                      ),
                                      Row(
                                        mainAxisSize: MainAxisSize.max,
                                        children: [
                                          Text(
                                            '123 Address St, City, ST',
                                            style: FlutterFlowTheme.of(context)
                                                .bodySmall
                                                .override(
                                                  fontFamily: 'Ubuntu',
                                                  fontSize: 16.0,
                                                ),
                                          ),
                                        ],
                                      ),
                                      Row(
                                        mainAxisSize: MainAxisSize.max,
                                        children: [
                                          Text(
                                            '1.7 km',
                                            style: FlutterFlowTheme.of(context)
                                                .bodyMedium
                                                .override(
                                                  fontFamily: 'Ubuntu',
                                                  color: Color(0xFFFF0000),
                                                  fontSize: 16.0,
                                                  fontWeight: FontWeight.w500,
                                                ),
                                          ),
                                        ],
                                      ),
                                    ],
                                  ),
                                ),
                              ),
                              Column(
                                mainAxisSize: MainAxisSize.max,
                                children: [
                                  Expanded(
                                    child: Padding(
                                      padding: EdgeInsetsDirectional.fromSTEB(
                                          0.0, 0.0, 8.0, 0.0),
                                      child: Icon(
                                        Icons.chevron_right_outlined,
                                        color: Color(0xFF95A1AC),
                                        size: 24.0,
                                      ),
                                    ),
                                  ),
                                ],
                              ),
                            ],
                          ),
                        ),
                      ),
                    ],
                  ),
                ),
              ),
            ],
          ),
          Align(
            alignment: AlignmentDirectional(1.0, 1.0),
            child: Padding(
              padding: EdgeInsetsDirectional.fromSTEB(0.0, 16.0, 16.0, 20.0),
              child: FFButtonWidget(
                onPressed: () {
                  print('Button pressed ...');
                },
                text: 'Map View',
                options: FFButtonOptions(
                  width: 95.0,
                  height: 40.0,
                  padding: EdgeInsetsDirectional.fromSTEB(0.0, 0.0, 0.0, 0.0),
                  iconPadding:
                      EdgeInsetsDirectional.fromSTEB(0.0, 0.0, 0.0, 0.0),
                  color: Color(0xFFFF0000),
                  textStyle: FlutterFlowTheme.of(context).bodyMedium.override(
                        fontFamily: 'Poppins',
                        color: Colors.white,
                      ),
                  elevation: 2.0,
                  borderSide: BorderSide(
                    color: Colors.transparent,
                    width: 1.0,
                  ),
                ),
              ),
            ),
          ),
        ],
      ),
    );
  }
}
