package za.ac.cput.ermotorsports.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Rudi.Zeeman on 14.10.15.
 */
@Entity
public final class ListOfParts
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long list_id;
    private Long car_id;
    private Long engineNo;
    private Long partID;

    private ListOfParts(){};

    private ListOfParts(Build build)
    {
        list_id = build.list_id;
        car_id = build.car_id;
        engineNo = build.engineNo;
        partID = build.partID;
    }

    public static class Build
    {
        private Long list_id;
        private Long car_id;
        private Long engineNo;
        private Long partID;

        public Build copy(ListOfParts listOfParts)
        {
            this.list_id = listOfParts.list_id;
            this.car_id = listOfParts.car_id;
            this.engineNo = listOfParts.engineNo;
            this.partID = listOfParts.partID;

            return this;
        }

        //Mandatory builder
        public Build(Long id){this.car_id = id;}


        //Getters
        public Build list_id(Long list_id)
        {
            this.list_id = list_id;
            return this;
        }

        public Build engineNo(Long engineNo)
        {
            this.engineNo = engineNo;
            return this;
        }

        public Build partID(Long partID)
        {
            this.partID = partID;
            return this;
        }

        public ListOfParts build(){return new ListOfParts(this);}
    }

    //Getters
    public Long getList_id() {
        return list_id;
    }

    public Long getCar_id() {
        return car_id;
    }

    public Long getEngineNo() {
        return engineNo;
    }

    public Long getPartID() {
        return partID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListOfParts listOfParts = (ListOfParts) o;

        return list_id.equals(listOfParts.list_id);

    }

    @Override
    public int hashCode() {
        return list_id.hashCode();
    }

    @Override
    public String toString() {
        return "ListOfParts{" +
                "car_id=" + car_id +
                ", engineNo=" + engineNo +
                ", partID=" + partID +
                '}';
    }
}