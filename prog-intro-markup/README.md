<h4 id="markup">Домашнее задание 7. Разметка</h4>
<ol><li>
            Разработайте набор классов для текстовой разметки.
        </li><li>
            Класс <code>Paragraph</code> может содержать произвольное
            число других элементов разметки и текстовых элементов.
        </li><li>
            Класс <code>Text</code> – текстовый элемент.
        </li><li>
            Классы разметки <code>Emphasis</code>, <code>Strong</code>, <code>Strikeout</code>
            – выделение, сильное выделение и зачеркивание.
            Элементы разметки могут содержать произвольное
            число других элементов разметки и текстовых элементов.
        </li><li>
            Все классы должны реализовывать метод <code>toMarkdown(<a href="https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/StringBuilder.html">StringBuilder</a>)</code>,
            который должен генерировать <a href="https://ru.wikipedia.org/wiki/Markdown">Markdown</a>-разметку
            по следующим правилам:
            <ul><li>
                    текстовые элементы выводятся как есть;
                </li><li>
                    выделенный текст окружается символами '<code>*</code>';
                </li><li>
                    сильно выделенный текст окружается символами '<code>__</code>';
                </li><li>
                    зачеркнутый текст окружается символами '<code>~</code>'.
                </li></ul></li><li>
            Следующий код должен успешно компилироваться:
<pre>    Paragraph paragraph = new Paragraph(List.of(
        new Strong(List.of(
            new Text("1"),
            new Strikeout(List.of(
                new Text("2"),
                new Emphasis(List.of(
                    new Text("3"),
                    new Text("4")
                )),
                new Text("5")
            )),
            new Text("6")
        ))
    ));
</pre>
            Вызов <code>paragraph.toMarkdown(new StringBuilder())</code>
            должен заполнять переданный <code>StringBuilder</code>
            следующим содержимым:
<pre>    __1~2*34*5~6__
</pre></li><li>
            Разработанные классы должны находиться в пакете <code>markup</code>.
        </li></ol>


Модификация
* *BBCode* (32-35)
    * Дополнительно реализуйте метод `toBBCode`, генерирующий [BBCode](https://en.wikipedia.org/wiki/BBCode)-разметку:
        * выделеный текст окружается тегом `[i]`;
        * сильно выделеный текст окружается тегом `[b]`;
        * зачеркнутый текст окружается тегом `[s]`.
* *BBCodeList* (36-39)
    * Сделайте модификацию *BBCode*
    * Добавьте поддержку:
        * Нумерованных списков (класс `OrderedList`, тег `[list=1]`): последовательность элементов
        * Ненумерованных списков (класс `UnorderedList`, тег `[list]`): последовательность элементов
        * Элементов списка (класс `ListItem`, открывающий тег `[*]`): последовательность абзацев и списков
    * Для новых классов поддержка Markdown не требуется
