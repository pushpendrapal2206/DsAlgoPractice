1. **Build a Stock Management platform (e.g. Zerodha).**

        * Primary Use case : 
            1. Stock buy/sell(Order Management)
        * Secondary Use Cases : 
            1. Stock prices are coming from 3rd party system(Prices shouldn't be stale).
            2. Have integration with clearing firm to clear the buy/sell orders.
            3. Generating reports and reconciliation.
        * NFR Requirements : 
            1. Total users : ~140 cr
            2. DAU - 100 M * 3 ->  300 M buy/sell (9:15 A.M. to 3:30 pm)
        * NFR : 
            1. Data should be consistent.
            2. This should be highly available.

2. **Develop an ad-server for an ecommerce app.**

        In this app there are different pages for different categories of products(Ex: Tshirts, Sarees, Shoes..etc). Whenever a user opens a page, we need to display ad-products belonging to that category. Adserver needs to expose the API for the same.
        Adserver should also expose an API for the sellers to create Ads on their products. At the time of Ad creation, seller will specify product he wants to advertise, cost that he is willing to pay for each click(say cost_per_click), budget  and the categories in which he wants to advertise.
            * Ad serving logic: Whenever a user comes to a category page, serve the ad-product that has the highest cost_per_click in that category. Track the clicks we are receiving on the ad-products and stop serving the ad-product, once the budget has reached.
            * max 100 ads on single page
            * number of ads can be millions
    
            * Expectations:
                * HLD
                * LLD
                * API & DB schemas

3. **CoinDCX works with various market exchanges to get real-time updates on Fiat <> Crypto exchange rates.**

        How would you design such a service that communicates with several hundred exchanges and provides real-time and best available rates to the users?
        Exchanges: Coindcx, Binance, Huobi, Coinbase, Hitbtc -> 100
        Markets: BTCUSD+, ETHUSD, BTCINR, ETHINR, DOGEUSD, TRXUSD

        HTTP GET https://api.binance.com/current_prices / https://api.coindcx.com/current_prices
        Response: { BTCUSD: 40000, BTCINR: 3200000, ETHUSD: 3000, ETHINR: 240000 }

        Websocket: wss://stream.binance.com / wss://stream.coindcx.com
        SUBSCRIBE current-prices
        Message: { BTCUSD: 40000, BTCINR: 3200000, ETHUSD: 3000, ETHINR: 240000 }

        e.g. Compare BTCINR price across multiple exchanges and determine best price

        1. what is the frequency exchange rates change (conrolled by the frquency users lookking into the data configurable) ?
        2. Data to be available as fast as possible ?
        3. 1 cr total registered users 10% active users.
        4. highly available, fault tolerant, as fast as possible.

4. **Design a rate limiter.**

5. **Design snake and ladders Game(LLD)**

        1. Design snake and ladder (low level classes)
        2. Minimum number of move needed given that die can be asked to give a particular number (from a given position).
        Followup : 
           We want to create a multiplayer game as a service
              signup
              login
              play the game
              for every player show (min moves to win).
              should be able to spectate (not part of the game only logged in users).
              pause the game (whether to allow a player to play more than one game)
              we shouldn’t allow joining started games
              user can see past games and their status
              game will end if a player leaves.
              last 2-3 hours then abandon the game.
              player can specify the number of players.

6. **Design a Highway toll management System(HLD).**

7. **Design an experimentation based system to turn on/off the features using flags along with a rule engine.**   		