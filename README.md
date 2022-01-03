# Morse
just a simple morse translator with sound effects

# Example
```
int count = 0;
while (count < 3){
   Scanner s = new Scanner(System.in);
   String input = s.nextLine();
   String translate = morseTranslator.englishToMorse(input);
   System.out.println("Converted English : " + translate);
   morseTranslator.speck(translate);
   count++;
}
```
