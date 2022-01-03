# Morse

just a simple morse translator with sound effects

# Example

```java
int count=0;
        while(count< 3){
        Scanner s=new Scanner(System.in);
        String input=s.nextLine();
        String translate=MorseTranslator.englishToMorse(input);
        System.out.println("Converted English : "+translate);
        MorseTranslator.speak(translate);
        count++;
        }
```
