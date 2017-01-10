keytool -genkeypair -keystore server.jks -alias server -dname "CN=localhost" -keyalg RSA -keysize 2048 -storepass changeit -keypass changeit
----------------
http://stackoverflow.com/questions/38532210/how-to-integrate-angular-js-2-java-maven-web-application
----------------
https://angular.io/docs/ts/latest/cookbook/component-communication.html кукбук по коммуникации между компонентами
----------------
from classpath:webapp run:
    npm install
    npm run tsc
----------------
http://jasonwatmore.com/post/2016/09/29/angular-2-user-registration-and-login-example-tutorial#alert-component-ts
https://github.com/cornflourblue/angular2-registration-login-example
----------------
Новый синтаксис в ангулар 2 https://habrahabr.ru/post/274743/:
1. биндинг значений
<input [value]="valueExpression" [placeholder]="placeholderExpression" /> //скобки это сахар для
<input bind-value="valueExpression" bind-placeholder="placeholderExpression" />
ассоциация с element[prop] = 'value';
так же есть возможность мэпить интерполируемое значение, так же как это было в AngularJS:
<input value="{{ valueExpression }}" placeholder="{{ placeholderExpression }}" />
часто с использованием @Input() title:string; в Компоненте

2. подписаться на события
<button (click)="doSomething($event)"> // это сахар для
<button ng-click="doSomething($event)">
ассоциация с element.addEventListener('click', ($event) => doSomething($event));

3. двусторонний биндинг
<input type="text" [value]="firstName" (input)="firstName=$event.target.value" />
<input type="text" [(ngModel)]="firstName" />

4. ссылки на любой объект или DOM в пределах елемента шаблона исрользуя локальные переменные
<video #movieplayer ...>
  <button (click)="movieplayer.play()">
</video>

Благодаря локальным переменным нам больше не нужно делать новые директивы всякий раз, когда действия над одними
элементами должны менять что-то у других. Например, в примере выше, мы можем быстро добавить кнопку которая запускает
просмотр видео. В этом собственно главное концептуальное отличие Angular2 от AngularJS, меньше бесполезных
микро-директив, большая концентрация внимания на компонентах.

5. шаблоны: синтаксический сахар для достижения более высокой производительности при использовании условных
директив вроде ngFor, ngIf и ngSwitch
<hero-detail *ngIf="isActive" [hero]="currentHero"></hero-detail>

6. Elvis оператор
<button (click)="employer?.goToWork()">Go To Work</button> ->
<button (click)="employer === undefined ? : employer.goToWork()">Go To Work</button>
----------------
ngSemantic examples https://github.com/vladotesanovic/ngSemantic/blob/master/demo/app/components/elements/form.ts
----------------
angular 2 api https://angular.io/docs/ts/latest/api/forms/index/FormControl-class.html
----------------
l.iv..luc.l
m.md
----------------
http://onehungrymind.com/build-better-angular-2-application-redux-ngrx/ events - UP, state - DOWN
----------------
//TODO добавить sm-rating
----------------