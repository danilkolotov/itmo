<h4 id="java-tabulator">Домашнее задание 5. Вычисление в различных типах</h4>
<p>
        Добавьте в программу разбирающую и вычисляющую выражения 
        трех переменных поддержку вычисления в различных типах.
    </p>
<ol><li><p>
                Создайте класс <code>expression.generic.GenericTabulator</code>,
                реализующий интерфейс <code>expression.generic.Tabulator</code>:
            </p><pre>    public interface Tabulator {
        Object[][][] tabulate(
            String mode, String expression, 
            int x1, int x2, int y1, int y2, int z1, int z2
        ) throws Exception;
    }
</pre><p>Аргументы</p><ul><li><code>mode</code> — режим работы
                    <table><tbody><tr><th>Режим</th><th>Тип</th></tr><tr><td><code>i</code></td><td><code>int</code> с детекцией переполнений</td></tr><tr><td><code>d</code></td><td><code>double</code></td></tr><tr><td><code>bi</code></td><td><code><a href="https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/math/BigInteger.html">BigInteger</a></code></td></tr></tbody></table></li><li><code>expression</code> — вычисляемое выражение;
                </li><li><code>x1</code>, <code>x2</code>;
                    <code>y1</code>, <code>y2</code>;
                    <code>z1</code>, <code>z2</code> —
                    диапазоны изменения переменных (включительно).
                </li></ul><p>
                Возвращаемое значение — таблица значений функции, где
                <code>R[i][j][k]</code> соответствует 
                <code>x = x1 + i</code>, <code>y = y1 + j</code>, <code>z = z1 + k</code>.
                Если вычисление завершилось ошибкой, в соответствующей ячейке
                должен быть <code>null</code>.
            </p></li><li>
            Доработайте интерфейс командной строки:
            <ul><li>
                    Первым аргументом командной строки программа должна принимать указание
                    на тип, в котором будут производится вычисления:
                    <table><tbody><tr><th>Опция</th><th>Тип</th></tr><tr><td><code>-i</code></td><td><code>int</code> с детекцией переполнений</td></tr><tr><td><code>-d</code></td><td><code>double</code></td></tr><tr><td><code>-bi</code></td><td><code><a href="https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/math/BigInteger.html">BigInteger</a></code></td></tr></tbody></table></li><li>
                    Вторым аргументом командной строки программа должна принимать
                    выражение для вычисления.
                </li><li>
                    Программа должна выводить результаты вычисления для
                    всех целочисленных значений переменных из диапазона −2..2.
                </li></ul></li><li>
            Реализация не должна содержать
            <a href="https://docs.oracle.com/javase/specs/jls/se17/html/jls-5.html#jls-5.1.9">непроверяемых преобразований типов</a>.
        </li><li>
            Реализация не должна использовать аннотацию
            <code><a href="https://docs.oracle.com/javase/specs/jls/se17/html/jls-9.html#jls-9.6.4.5">@SuppressWarnings</a></code>.
        </li><li>
            При выполнении задания следует обратить внимание на простоту добавления новых типов и операциий.
        </li></ol>

Модификация
 * *CmmUbs* (38, 39)
    * Реализуйте операции из модификации *Cmm*.
    * Дополнительно реализуйте поддержку режимов:
        * `u` – вычисления в `int` без проверки на переполнение;
        * `b` – вычисления в `byte` без проверки на переполнение,
        * `sat` – вычисления с насыщением.


