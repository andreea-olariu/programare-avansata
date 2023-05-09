1. Create the project ServerApplication. This will contain (at least) the classes: GameServer and ClientThread.
2. Create the class GameServer. An instance of this class will create a ServerSocket running at a specified port. The server will receive requests (commands) from clients and it will execute them.

PORT: 8000
In clasa GameServer pornesc cate un Thread pentru fiecare client in care astept comenzi si trimit raspunsul prin socket

3. Create the class ClientThread. An instance of this class will be responsible with communicating with a client Socket. If the server receives the command stop it will stop and will return to the client the respons "Server stopped", otherwise it return: "Server received the request ... ".

Am creat inca un Thread StopServerThread care asteapta comenzi de la tastatura si, cand primeste "stop" da exit intregului program si trimite clientului mesajul

4. Create the project ClientApplication. This will contain (at least) the class: GameClient.
5. Create the class GameClient. An instance of this class will read commands from the keyboard and it will send them to the server. The client stops when it reads from the keyboard the string "exit".

Trimit comenzile prin socket-ul creat ce se conecteaza la server prin adresa si portul corespunzator si primesc comenzi de la tastatura pana cand comanda primita este "stop" si opresc clientul, dar serverul inca ruleaza in asteptarea altor clienti
