package com.project.wildfire.Models.Enums;

/**
 * Enumeration for cell's status
 */
public enum CellStatus {
    /**
     * Default status
     */
    DEFAULT(Constant.DEFAULT_VALUE),

    /**
     * Status for trees
     */
    TREE(Constant.TREE_VALUE),

    /**
     * Status for fire
     */
    FIRE(Constant.FIRE_VALUE),

    /**
     * Status for cinders
     */
    CINDER(Constant.CINDER_VALUE);

    private CellStatus(String statusValue){

    }

    /**
     * Values for status
     */
    public static class Constant {
        /**
         * Default status value
         */
        public static final String DEFAULT_VALUE = "DEFAULT";

        /**
         * Tree status value
         */
        public static final String TREE_VALUE = "TREE";

        /**
         * Fire status value
         */
        public static final String FIRE_VALUE = "FIRE";

        /**
         * Cinder status value
         */
        public static final String CINDER_VALUE = "CINDER";
    }

}
