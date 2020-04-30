 # Spring boot com oauth2 nova feature
 
 Alguns detalhes da aplicação de exemplo:
 - Aplicação utiliza authentication stateless, ou seja,  não guarda o token em memoria.
 - Utiliza o jwt, para gerar um token enriquecido e não opaco.
 - Usa-se uma chave assimétrica para assinatura do token, ou seja, uma chave assina e outra valida (pública).
 - Utiliza 2 grant_types:
 1. Password
 1. Authorization code (exemplo para gerar o code: http://localhost:8080/oauth/authorize?response_type=code&client_id=appweb&state=abc&redirect_uri=http://localhost:8080)
 
###  Exemplos para gerar chaves
- Chave de assinatura:
```
keytool -genkeypair -alias teste -keyalg RSA -keypass 123456 -keystore teste.jks -storepass 123456 -validity 3650
```
- Chave publica
```
keytool -export -rfc -alias teste -keystore teste.jks -file teste-cert.pem

openssl x509 -pubkey -noout -in teste-cert.pem > teste-pkey.pem
```
