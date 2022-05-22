package android.famme.learnenglishapp.utils.themes;

import android.famme.learnenglishapp.data.storage.room.ResultEntity;

public class ResultsSetter implements Results {

    @Override
    public ResultEntity setTheme(String theme, int result, ResultEntity resultEntity) {

        if (result > 0) {
            result--;
        }

        String res = theme + " -" + result + "/10";

        System.out.println("setTheme " + theme);

        switch (theme.toLowerCase()) {
            case "personality":
                resultEntity.setPersonality(res);
                break;
            case "shopping":
                resultEntity.setShopping(res);
                break;
            case "education":
                resultEntity.setEducation(res);
                break;
            case "summer":
                resultEntity.setSummer(res);
                break;
            case "lifestyle":
                resultEntity.setLifestyle(res);
                break;
            case "life":
                resultEntity.setLife(res);
                break;
            case "family":
                resultEntity.setFamily(res);
                break;
            case "culture":
                resultEntity.setCulture(res);
                break;
            case "clothes":
                resultEntity.setClothes(res);
                break;
            case "books":
                resultEntity.setBooks(res);
                break;
            default:
                break;
        }

        return resultEntity;
    }

    @Override
    public ResultEntity getNewResultEntity(String login) {
        return new ResultEntity(
                login,
                "Personality -0/10",
                "Shopping -0/10",
                "Education -0/10",
                "Family -0/10",
                "Lifestyle -0/10",
                "Clothes -0/10",
                "Books -0/10",
                "Culture -0/10",
                "Life -0/10",
                "Summer -0/10"
        );
    }
}
