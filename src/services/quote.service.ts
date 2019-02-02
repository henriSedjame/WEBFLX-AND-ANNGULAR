import {Injectable, NgZone} from '@angular/core';
import {Quote} from '../app/models/quote';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class QuoteService {

  private readonly API_URL = 'http://localhost:8702/quotes';

  public quotes: Quote[] = [];

  constructor(private zone: NgZone){ }

  /**
   * Recuperation des quotes de manière réactive
   * grace à un EventSource
   */
  getQuoteStream(): Observable<Array<Quote>> {
    this.quotes = [];
    /**
     * On retourne un observable
     */
    return Observable.create(observer => {
      let url = this.API_URL;

      /**
       * On crée un EventSource sur notre URL
        */
      let eventSrc = new EventSource(url);

      /**
       * On définit l'action à la réception du message
        */
      eventSrc.onmessage = event => {
        /**
         * à la réception de chaque message
         * On crée un quote
         */
        let quote = Quote.of(event.data);

        /**
         * On alimente notre tableau de quotes
         */
        this.quotes.push(quote);

        /**
         * on appelle la méthode run sur notre ngZone
         * l'observer souscrit à notre tableau
         *
         */
        this.zone.run(() => observer.next(this.quotes));

      };

      // On définit l'action en cas d'erreur
      eventSrc.onerror = error => {
        if(eventSrc.readyState === 0){
          eventSrc.close();
          observer.complete();
        }else{
          observer.error('EventSource error : ' + error.data );
        }
      };

    });
  }
}
