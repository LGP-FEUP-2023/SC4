import 'dart:convert';
import 'dart:typed_data';

import '../../flutter_flow/flutter_flow_util.dart';

import 'api_manager.dart';

export 'api_manager.dart' show ApiCallResponse;

const _kPrivateApiFunctionName = 'ffPrivateApiCall';

class GetCategoriesCall {
  static Future<ApiCallResponse> call({
    String? serviceName = 'name',
    String? image = 'imgUrl',
  }) {
    return ApiManager.instance.makeApiCall(
      callName: 'Get Categories',
      apiUrl:
          'https://service-provider.blackforest-8c6cc863.northeurope.azurecontainerapps.io/api/service-provider-category-entity/v1/category/all',
      callType: ApiCallType.GET,
      headers: {},
      params: {},
      returnBody: true,
      encodeBodyUtf8: false,
      decodeUtf8: false,
      cache: false,
    );
  }

  static dynamic names(dynamic response) => getJsonField(
        response,
        r'''$..name''',
        true,
      );
  static dynamic images(dynamic response) => getJsonField(
        response,
        r'''$..imgUrl''',
        true,
      );
  static dynamic all(dynamic response) => getJsonField(
        response,
        r'''$''',
        true,
      );
}

class GetServicesProviderCall {
  static Future<ApiCallResponse> call() {
    return ApiManager.instance.makeApiCall(
      callName: 'Get Services Provider',
      apiUrl:
          'https://service-provider.blackforest-8c6cc863.northeurope.azurecontainerapps.io/api/service-provider-entity/v1/serviceprovider/all',
      callType: ApiCallType.GET,
      headers: {},
      params: {},
      returnBody: true,
      encodeBodyUtf8: false,
      decodeUtf8: false,
      cache: false,
    );
  }

  static dynamic all(dynamic response) => getJsonField(
        response,
        r'''$''',
        true,
      );
}

class LoginCall {
  static Future<ApiCallResponse> call({
    String? email = '',
    String? password = '',
  }) {
    final body = '''
{
  "email": "${email}",
  "password": "${password}"
}''';
    return ApiManager.instance.makeApiCall(
      callName: 'Login',
      apiUrl:
          'https://user-entity.blackforest-8c6cc863.northeurope.azurecontainerapps.io/api/user-entity/v1/user/login',
      callType: ApiCallType.POST,
      headers: {},
      params: {},
      body: body,
      bodyType: BodyType.JSON,
      returnBody: true,
      encodeBodyUtf8: false,
      decodeUtf8: false,
      cache: false,
    );
  }
}

class GetUserByIDCall {
  static Future<ApiCallResponse> call({
    String? id = '',
    String? authToken = '',
  }) {
    return ApiManager.instance.makeApiCall(
      callName: 'Get User by ID',
      apiUrl:
          'https://user-entity.blackforest-8c6cc863.northeurope.azurecontainerapps.io/api/user-entity/v1/user/${id}',
      callType: ApiCallType.GET,
      headers: {
        'Authorization': 'Bearer ${authToken}',
      },
      params: {},
      returnBody: true,
      encodeBodyUtf8: false,
      decodeUtf8: false,
      cache: false,
    );
  }
}

class RegisterCall {
  static Future<ApiCallResponse> call({
    String? firstName = '',
    String? lastName = '',
    String? email = '',
    String? password = '',
  }) {
    final body = '''
{
  "firstName": "${firstName}",
  "lastName": "${lastName}",
  "email": "${email}",
  "password": "${password}"
}''';
    return ApiManager.instance.makeApiCall(
      callName: 'Register',
      apiUrl:
          'https://user-entity.blackforest-8c6cc863.northeurope.azurecontainerapps.io/api/user-entity/v1/user/register',
      callType: ApiCallType.POST,
      headers: {},
      params: {},
      body: body,
      bodyType: BodyType.JSON,
      returnBody: true,
      encodeBodyUtf8: false,
      decodeUtf8: false,
      cache: false,
    );
  }
}

class ApiPagingParams {
  int nextPageNumber = 0;
  int numItems = 0;
  dynamic lastResponse;

  ApiPagingParams({
    required this.nextPageNumber,
    required this.numItems,
    required this.lastResponse,
  });

  @override
  String toString() =>
      'PagingParams(nextPageNumber: $nextPageNumber, numItems: $numItems, lastResponse: $lastResponse,)';
}

String _serializeList(List? list) {
  list ??= <String>[];
  try {
    return json.encode(list);
  } catch (_) {
    return '[]';
  }
}

String _serializeJson(dynamic jsonVar) {
  jsonVar ??= {};
  try {
    return json.encode(jsonVar);
  } catch (_) {
    return '{}';
  }
}
