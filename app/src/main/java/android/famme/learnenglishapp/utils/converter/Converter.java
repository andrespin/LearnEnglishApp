package android.famme.learnenglishapp.utils.converter;

import android.famme.learnenglishapp.data.storage.room.ResultEntity;

import java.util.ArrayList;

public class Converter implements IConverter{
    @Override
    public ArrayList<String> convertResultEntityToListOfResults(ResultEntity resultEntity) {
        ArrayList<String> list = new ArrayList<>();

        try {
            list.add(resultEntity.getPersonality());
        } catch (NullPointerException e) {

        }

        try {
            list.add(resultEntity.getShopping());
        } catch (NullPointerException e) {

        }

        try {
            list.add(resultEntity.getEducation());
        } catch (NullPointerException e) {

        }

        try {
            list.add(resultEntity.getFamily());
        } catch (NullPointerException e) {

        }

        try {
            list.add(resultEntity.getLifestyle());
        } catch (NullPointerException e) {

        }

        try {
            list.add(resultEntity.getClothes());
        } catch (NullPointerException e) {

        }

        try {
            list.add(resultEntity.getBooks());
        } catch (NullPointerException e) {

        }

        try {
            list.add(resultEntity.getCulture());
        } catch (NullPointerException e) {

        }

        try {
            list.add(resultEntity.getLife());
        } catch (NullPointerException e) {

        }

        try {
            list.add(resultEntity.getSummer());
        } catch (NullPointerException e) {

        }

        return list;
    }

}
