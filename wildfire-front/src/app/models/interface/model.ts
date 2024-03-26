/**
 * Parent class for models
 */
export interface Model {

  /**
   * Method to hydrate object from json
   * @param json Json object
   */
  fromJSON(json: any): any;
}
