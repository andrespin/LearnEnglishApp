package android.famme.learnenglishapp.utils.converter;

import android.famme.learnenglishapp.data.storage.room.ResultEntity;

import java.util.ArrayList;

public interface IConverter {

    /**
     * @param resultEntity
     * @return Конвертирует переменную типа ResultEntity в
     * список ArrayList<String> с результатами для отображения
     * адаптером во View.
     */

    ArrayList<String> convertResultEntityToListOfResults(ResultEntity resultEntity);


}
