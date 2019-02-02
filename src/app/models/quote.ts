export class Quote {
  public id: any;
  public book: any;
  public content: any;

  public static of(json: any): Quote{
    let quote: Quote = new Quote();
    Object.assign(quote, JSON.parse(json));
    return quote;
  }
}
