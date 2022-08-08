package android.famme.learnenglishapp.utils.converter;

import android.famme.learnenglishapp.data.storage.room.ResultEntity;
import android.famme.learnenglishapp.ui.progress.graph.ResultsData;

import java.util.ArrayList;

public class Converter implements IConverter {

    @Override
    public ArrayList<String> convertResultEntityToListOfResults(ResultEntity resultEntity) {
        ArrayList<String> list = new ArrayList<>();
        list.add(resultEntity.getPersonality());
        list.add(resultEntity.getShopping());
        list.add(resultEntity.getEducation());
        list.add(resultEntity.getFamily());
        list.add(resultEntity.getLifestyle());
        list.add(resultEntity.getClothes());
        list.add(resultEntity.getBooks());
        list.add(resultEntity.getCulture());
        list.add(resultEntity.getLife());
        list.add(resultEntity.getSummer());
        return list;
    }

}
