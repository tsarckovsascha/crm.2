package funfactions;

import entity.DisciplinMark;
import entity.Term;

import java.util.ArrayList;

public class Functions {
    public static Term getAllStudentProgress(ArrayList<Term> arr, String id){
      for (Term term : arr ) {
          if (term.getId() == Integer.parseInt(id))
          return term;
      }
        return arr.get(0) ;
    }
    public static double getAvaradeaMark(ArrayList<DisciplinMark> disciplinMark){
        double res = 0;
        for (DisciplinMark dm: disciplinMark ) {
            res = res + Double.parseDouble(dm.getMark());
        }

        double asDouble = disciplinMark.stream().mapToInt(value -> Integer.parseInt(value.getMark())).average().getAsDouble();

        return asDouble ;
    }

}
