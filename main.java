//Declaração das variáveis referentes aos pinos digitais.
int pinBuzzer = 7;
int pinSensorPIR = 8;
int pinLed = 9;
int valorSensorPIR = 0;
 
void setup() {
  Serial.begin(9600); //Inicializando o serial monitor
 
  //Definido pinos como de entrada ou de saída
  pinMode(pinBuzzer,OUTPUT);
  pinMode(pinSensorPIR,INPUT);
  pinMode(pinLed,OUTPUT);
}
 
void loop() {  
  //Lendo o valor do sensor PIR. Este sensor pode assumir 2 valores
  //1 quando detecta algum movimento e 0 quando não detecta.
  valorSensorPIR = digitalRead(pinSensorPIR);
   
  Serial.print("Valor do Sensor PIR: ");  
  Serial.println(valorSensorPIR);
   
  //Verificando se ocorreu detecção de movimentos
  if (valorSensorPIR == 1) {
    ligarAlarme();
  } else {
    desligarAlarme();
  }    
}
 
void ligarAlarme() {
  //Ligando o led
  digitalWrite(pinLed, HIGH);
   
  //Ligando o buzzer com uma frequencia de 1500 hz.
  tone(pinBuzzer,1500);
   
  delay(4000); //tempo que o led fica acesso e o buzzer toca
   
  desligarAlarme();
}
 
void desligarAlarme() {
  //Desligando o led
  digitalWrite(pinLed, LOW);
   
  //Desligando o buzzer
  noTone(pinBuzzer);
}
