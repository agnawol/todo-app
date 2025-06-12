Kluczowe funkcjonalności aplikacji TODO List:
1)	Dodawanie tasków 
2)	Usuwanie tasków
3)	Edycja tasków
4)	Filtrowanie listy tasków

Scenariusze testowe do aplikacji TODO List umieszczonej pod adresem https://wc-react-todo-app.netlify.app/ :

1)	Dodanie taska
Warunki wstępne:
 	- dostępność aplikacji
- filtr wyszukiwania ustawiony na All

Kroki:
1.	Wciśnij przycisk Add Task - otwiera się okno Add TODO
2.	W oknie TODO w polu Title wpisz nazwę taska
3.	Wciśnij przycisk Cancel – okno Add TODO zamyka się, task nie został dodany
4.	Ponownie przycisk Add Task - otwiera się okno Add TODO
5.	W oknie TODO w polu Title wpisz nazwę taska, nie zmieniaj statusu
6.	Wciśnij przycisk Add Task – okno Add TODO zamyka się, task widoczny jest na liście
Wynik oczekiwany: 
Na liście TODO widoczny jest task o tytule podanym w kroku 5 w statusie Incomplete.

2)	Usunięcie taska
Warunki wstępne: 
- dostępność aplikacji 
- przynajmniej jeden dodany task w dowolnym statusie

Kroki:
1.	Na liście tasków kliknij ikonę kosza na śmieci -  task znika z listy TODO
Wynik oczekiwany:
Usunięty task nie jest widoczny na liście.

3)	Edycja taska
Warunki wstępne:
- dostępność aplikacji 
- przynajmniej jeden dodany task w statusie Incomplete
- filtr wyszukiwania ustawiony na All

Kroki:
1.	Na liście tasków kliknij w ikonę ołówka przy edytowanym tasku – otwiera się okno Update TODO
2.	Edytuj tytuł 
3.	Kliknij przycisk Cancel, okno Update TODO zamyka się , dane nie zostają zmienione
4.	Ponownie kliknij w ikonę ołówka przy edytowanym tasku – otwiera się okno Update TODO
5.	Edytuj tytuł i zmień status na Complete
6.	Kliknij przycisk Update Task, okno Update TODO zamyka się 
7.	Z lewej strony taska kliknij w kwadrat , kwadrat zostaje odznaczony, task zmienia status na Incomplete

Wynik oczekiwany:
Zaktualizowany task jest widoczny na liście z nowym tytułem i zmienionym statusem.

4)	Filtrowanie tasków
Warunki wstępne:

- dostępność aplikacji 
- dodanych po 2-3 taski w każdym statusie
- filtr wyszukiwania ustawiony na All

Kroki:
1.	Zweryfikuj wyświetlane taski, wyświetlane są taski w obu dostępnych statusach
2.	Na liście tasków wybierz z filtra wartość Complete, wyświetlane są taski w statusie Complete
3.	Na liście tasków wybierz z filtra wartość Incomplete, wyświetlane są taski w statusie Incomplete
4.	Przy tasku w statusie Incomplete kliknij w kwadrat po lewej strony taska, task znika z listy
5.	Na liście tasków wybierz z filtra wartość Complete, wyświetlane są taski w statusie Complete, wśród nich task dla którego zmieniono status w kroku 4.

Wynik oczekiwany:
Filtrowanie tasków działa poprawnie wyświetlając tylko taski w danym statusie, również w przypadku zmiany statusu.


5)	Komunikaty informacyjne
Warunki wstępne: 
-dostępność aplikacji

Kroki:
1.	Wciśnij przycisk Add Task - otwiera się okno Add TODO
2.	Nie podawaj tytułu i wciśnij przycisk Add Task – w prawym dolnym rogu pojawia się informacja „Please enter title”
3.	W oknie Add TODO w polu Title wpisz nazwę taska, nie zmieniaj statusu
4.	Wciśnij przycisk Add Task – okno Add TODO zamyka się, w prawym dolnym rogu pojawia się informacja „Task added successfully”
5.	Na liście tasków kliknij w ikonę ołówka przy dodanym tasku – otwiera się okno Update TODO
6.	Bez wprowadzania zmian wciśnij przycisk Update TODO – pojawia się informacja „No changes made”
7.	Wpisz dowolny tytuł
8.	Kliknij przycisk Update Task - w prawym dolnym rogu pojawia się informacja „Task Updated successfully”
9.	Na liście tasków kliknij ikonę kosza na śmieci - w prawym dolnym rogu pojawia się informacja „Todo Deleted Successfully”,


