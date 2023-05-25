import '/flutter_flow/flutter_flow_calendar.dart';
import '/flutter_flow/flutter_flow_drop_down.dart';
import '/flutter_flow/flutter_flow_icon_button.dart';
import '/flutter_flow/flutter_flow_theme.dart';
import '/flutter_flow/flutter_flow_util.dart';
import '/flutter_flow/form_field_controller.dart';
import 'package:flutter/material.dart';
import 'package:flutter_spinkit/flutter_spinkit.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:provider/provider.dart';
import 'agenda_book_model.dart';
export 'agenda_book_model.dart';

class AgendaBookWidget extends StatefulWidget {
  const AgendaBookWidget({Key? key}) : super(key: key);

  @override
  _AgendaBookWidgetState createState() => _AgendaBookWidgetState();
}

class _AgendaBookWidgetState extends State<AgendaBookWidget> {
  late AgendaBookModel _model;

  final scaffoldKey = GlobalKey<ScaffoldState>();
  final _unfocusNode = FocusNode();

  @override
  void initState() {
    super.initState();
    _model = createModel(context, () => AgendaBookModel());

    WidgetsBinding.instance.addPostFrameCallback((_) => setState(() {}));
  }

  @override
  void dispose() {
    _model.dispose();

    _unfocusNode.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    context.watch<FFAppState>();

    return GestureDetector(
      onTap: () => FocusScope.of(context).requestFocus(_unfocusNode),
      child: Scaffold(
        key: scaffoldKey,
        backgroundColor: FlutterFlowTheme.of(context).secondaryBackground,
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
          actions: [],
          centerTitle: true,
          elevation: 2.0,
        ),
        body: Column(
          mainAxisSize: MainAxisSize.max,
          mainAxisAlignment: MainAxisAlignment.spaceBetween,
          children: [
            FlutterFlowCalendar(
              color: Color(0xFFFF0000),
              iconColor: FlutterFlowTheme.of(context).secondaryText,
              weekFormat: false,
              weekStartsMonday: false,
              initialDate: getCurrentTimestamp,
              rowHeight: 64.0,
              onChange: (DateTimeRange? newSelectedDate) {
                setState(() => _model.calendarSelectedDay = newSelectedDate);
              },
              titleStyle: FlutterFlowTheme.of(context).headlineSmall.override(
                    fontFamily: 'Ubuntu',
                  ),
              dayOfWeekStyle: FlutterFlowTheme.of(context).labelLarge.override(
                    fontFamily: 'Ubuntu',
                  ),
              dateStyle: FlutterFlowTheme.of(context).bodyMedium.override(
                    fontFamily: 'Ubuntu',
                  ),
              selectedDateStyle:
                  FlutterFlowTheme.of(context).titleSmall.override(
                        fontFamily: 'Ubuntu',
                        color: FlutterFlowTheme.of(context).primaryBtnText,
                      ),
              inactiveDateStyle:
                  FlutterFlowTheme.of(context).labelMedium.override(
                        fontFamily: 'Ubuntu',
                        color: FlutterFlowTheme.of(context).grayIcon,
                      ),
            ),
            Row(
              mainAxisSize: MainAxisSize.max,
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                FlutterFlowDropDown<String>(
                  controller: _model.dropDownValueController ??=
                      FormFieldController<String>(null),
                  options: [
                    '09:00',
                    '10:00',
                    '10:30',
                    '11:00',
                    '11:30',
                    '14:00',
                    '14:30',
                    '15:00',
                    '15:30',
                    '16:00',
                    '16:30',
                    '17:00',
                    '17:30'
                  ],
                  onChanged: (val) =>
                      setState(() => _model.dropDownValue = val),
                  width: 300.0,
                  height: 50.0,
                  searchHintTextStyle: FlutterFlowTheme.of(context).labelMedium,
                  textStyle: FlutterFlowTheme.of(context).bodyMedium,
                  hintText: 'Please select book hour',
                  searchHintText: 'Search for an item...',
                  icon: Icon(
                    Icons.keyboard_arrow_down_rounded,
                    color: FlutterFlowTheme.of(context).secondaryText,
                    size: 24.0,
                  ),
                  fillColor: FlutterFlowTheme.of(context).secondaryBackground,
                  elevation: 2.0,
                  borderColor: Color(0x4E95A1AC),
                  borderWidth: 2.0,
                  borderRadius: 8.0,
                  margin: EdgeInsetsDirectional.fromSTEB(16.0, 4.0, 16.0, 4.0),
                  hidesUnderline: true,
                  isSearchable: false,
                ),
              ],
            ),
            Row(
              mainAxisSize: MainAxisSize.max,
              mainAxisAlignment: MainAxisAlignment.end,
              children: [
                Padding(
                  padding: EdgeInsetsDirectional.fromSTEB(0.0, 0.0, 10.0, 10.0),
                  child: FlutterFlowIconButton(
                    borderColor: Color(0xFFFF0000),
                    borderRadius: 20.0,
                    borderWidth: 1.0,
                    buttonSize: 45.0,
                    fillColor: Color(0xFFFF0000),
                    icon: Icon(
                      Icons.chevron_right_sharp,
                      color: FlutterFlowTheme.of(context).primaryBtnText,
                      size: 24.0,
                    ),
                    onPressed: () async {
                      context.pushNamed('resumeBook');
                    },
                  ),
                ),
              ],
            ),
          ],
        ),
      ),
    );
  }
}
