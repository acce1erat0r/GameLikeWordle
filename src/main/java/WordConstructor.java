public class WordConstructor implements IWordConstructor{



    @Override
    public StringBuilder constructWord(DataLetters dataLetters) {
        StringBuilder userWordle = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            if (dataLetters.getYellowLetters().containsKey(i)){
                userWordle.append(dataLetters.getYellowLetters().get(i));
            }
            if (dataLetters.getGreenLetters().containsKey(i)){
                userWordle.append(dataLetters.getGreenLetters().get(i));
            }
            if (dataLetters.getGrayLetters().containsKey(i)){
                userWordle.append(dataLetters.getGrayLetters().get(i));
            }
        }
        userWordle.append(ConstantsString.ANSI_RESET.getTitle());
        return userWordle;
    }
}
