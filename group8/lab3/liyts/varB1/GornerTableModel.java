package lab3.liyts.varB1;

import javax.swing.table.AbstractTableModel;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.DecimalFormatSymbols;

@SuppressWarnings("serial")
public class GornerTableModel extends AbstractTableModel {
    private Double[] coefficients;
    private Double from;
    private Double to;
    private Double step;
    private DecimalFormat formatter =
            (DecimalFormat) NumberFormat.getInstance();

    public GornerTableModel(Double from, Double to, Double step,
                            Double[] coefficients) {
        this.from = from;
        this.to = to;
        this.step = step;
        this.coefficients = coefficients;
        formatter.setGroupingUsed(false);           // без пробелов/запятых между тысячами
        formatter.setMaximumFractionDigits(5);
        formatter.setMinimumFractionDigits(0);      // без обязательных нулей в конце

        DecimalFormatSymbols dfs = formatter.getDecimalFormatSymbols();
        dfs.setDecimalSeparator('.');               // точка как разделитель
        formatter.setDecimalFormatSymbols(dfs);
    }
    public Double getFrom() {
        return from;
    }
    public Double getTo() {
        return to;
    }
    public Double getStep() {
        return step;
    }
    public int getColumnCount() {
// В данной модели два столбца(по варианту добавляю третий)
        return 3;
    }
    public int getRowCount() {
// Вычислить количество точек между началом и концом отрезка
// исходя из шага табулирования
        return new Double(Math.ceil((to-from)/step)).intValue()+1;
    }
    public Object getValueAt(int row, int col) {
// Вычислить значение X как НАЧАЛО_ОТРЕЗКА + ШАГ*НОМЕР_СТРОКИ
        double x = from + step*row;
//Считаем по Горнеру
        Double result = coefficients[0];
        for (int i = 1; i < coefficients.length; i++) {
            result = result * x + coefficients[i];
        }

        if (col == 0) {
            // Первый столбец — X
            return x;
        } else if (col == 1) {
            // Второй столбец — значение многочлена
            return result;
        } else {
            // Третий столбец — булево значение "есть ли две пары соседних одинаковых цифр"
            return hasTwoPair(result);
        }
    }

    // true, если в строковой записи числа есть ДВЕ непересекающиеся пары соседних одинаковых цифр
    private Boolean hasTwoPair(double value) {
        String s = formatter.format(Math.abs(value)); // красивое число без хвостов double

        int pairs = 0;
        int i = 0;

        while (i < s.length() - 1) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(i + 1);

            // Интересуют только цифры
            if (!Character.isDigit(c1) || !Character.isDigit(c2)) {
                i++;
                continue;
            }

            if (c1 == c2) {
                pairs++;
                if (pairs >= 2) {
                    return true;        // нашли как минимум две пары
                }
                i += 2;                 // пропускаем найденную пару, чтобы пары не пересекались
            } else {
                i++;
            }
        }
        return false;
    }

    public String getColumnName(int col) {
        switch (col) {
            case 0:
                return "Значение X";
            case 1:
                return "Значение многочлена";
            case 2:
                return "Две пары";
            default:
                return "";
        }
    }
    public Class<?> getColumnClass(int col) {
        switch (col) {
            case 0:
            case 1:
                // X и значение многочлена — Double
                return Double.class;
            case 2:
                // Третий столбец — Boolean
                return Boolean.class;
            default:
                return Object.class;
        }
    }
}
