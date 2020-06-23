package linkedList;
//Двохнаправлений зв'язний список
//Кожне входження в текст його першого однобуквеним слова замінити словом "yes",
//всі інші однобуквені слова видалити з тексту

public class RefactorList {
    TDLinkedList<String> target;
    String firstChar;
    RefactorList() {
    }

    ;

    public RefactorList(TDLinkedList<String> target) {
        this.target = target;
    }

    public void findChar() {
        for (String t : target) {
            if (t.length() == 1) {
                firstChar = t;
                break;
            }
        }

        for (int i =0; i < target.size(); i++){
            if (target.getElementByIndex(i) == firstChar)
                target.setValueByIndex(i, "yes");
        }

        while (!(firstChar == null)) {
            firstChar = null;
            for (String t : target) {
                if (t.length() == 1) {
                    firstChar = t;
                    break;
                }
            }

            for (int i =0; i < target.size(); i++){
                if (target.getElementByIndex(i) == firstChar)
                    target.removeByIndex(i);
            }

        }
    }
}