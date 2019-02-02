import {Component, OnInit} from '@angular/core';
import {Observable, of} from 'rxjs';
import {Quote} from './models/quote';
import {QuoteService} from '../services/quote.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{

  quotes: Observable<Array<Quote>>;
  selectedQuote: Quote;

  constructor(private service: QuoteService){}

  ngOnInit(): void {
    this.quotes = of([]);
  }

  getQuotes(){
    this.quotes = this.service.getQuoteStream();
  }

  public onSelect(quote: Quote): void{
    this.selectedQuote = quote;
    alert('Selected quote : ' + JSON.stringify(quote));
  }

}
