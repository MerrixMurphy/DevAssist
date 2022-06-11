public class BasicReact {
    String path;

    private void lvlOne() {
        try{
          Directory dir[] = {
            new Directory("front-end"),
            new Directory("back-end")};

          for(Directory d : dir){
            Directory.dirCreator(path, d.name);
          }

          FileBasics files[] = {
            new FileBasics(".gitignore", 
            """
              # dependencies
              node_modules/
              .pnp/
              .pnp.js
              
              # production
              build/
              
              # misc
              .eslintcache
              .DS_Store
              .env
              .env.*
              .idea/
              .vscode/
              .vercel
              .screenshots/
              
              npm-debug.log*
              yarn-debug.log*
              yarn-error.log*  
                  """),
            new FileBasics("package.json", 
            """
              {
                  \"name\": \"dynamic-react-app\",
                  \"version\": \"1.0.0\",
                  \"description\": \"dynamic description\",
                  \"private\": true,
                  \"repository\": {
                      \"type\": \"git\",
                      \"url\": \"https://github.com/MerrixMurphy/dynamic-react-app\"
                  },
                  \"scripts\": {
                      \"build\": \"npm -prefix front-end run build\",
                      \"preinstall\": \"cd ./back-end && npm install\",
                      \"install\": \"cd ./front-end && npm install\",
                      \"start\": \"npx concurrently 'npm run start:backend' 'npm run start:frontend'\",
                      \"start:backend\": \"npm --prefix ./back-end start\",
                      \"start:frontend\": \"npm --prefix ./front-end start\",
                      \"start:dev\": \"npx concurrently \"npm run start:dev --prefix ./back-end\" \"npm start --prefix ./front-end\" \"
                  },
                  \"keywords\": [],
                  \"author\": \"Merrix Murphy\",
                  \"license\": \"UNLICENSED\",
                  \"dependencies\": {
                      \"node-fetch\": \"^3.2.4\"
                  }
              }
              """), 
              new FileBasics("README.md", 
              """
              # Dynamic React App
  
              ## Current Status: Development
              
               Summary
            """)
          };

          for(FileBasics f : files){
            FileBasics.fileCreator(path, f.name, f.content);
          }

          } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    private void lvlTwo() {
        try {
          Directory dir[] = {
            new Directory("front-end/src"),
            new Directory("front-end/public"),
            new Directory("back-end/src")};

          for(Directory d : dir){
            Directory.dirCreator(path, d.name);
          }

          FileBasics files[] = {
            new FileBasics("back-end/package.json", 
            """
              {
                \"name\": \"dynamic-react-app-back-end\",
                \"version\": \"1.0.0\",
                \"description\": \"dynamic react app backend.\",
                \"main\": \"src/server.js\",
                \"repository\": {
                    \"type\": \"git\",
                    \"url\": \"https://github.com/MerrixMurphy/dynamic-react-app\",
                    \"directory\": \"/back-end\"
                },
                \"scripts\": {
                    \"start\": \"node src/server.js\",
                    \"start:dev\": \"nodemon src/server.js\"
                },
                \"keywords\": [],
                \"author\": \"Merrix Murphy\",
                \"license\": \"UNLICENSED\",
                \"dependencies\": {
                    \"cors\": \"^2.8.5\",
                    \"dotenv\": \"^16.0.0\",
                    \"express\": \"^4.17.3\",
                    \"knex\": \"^1.0.4\",
                    \"nanoid\": \"^3.3.2\",
                    \"node-fetch\": \"^3.2.3\",
                    \"npm-run-all\": \"^4.1.5\",
                    \"pg\": \"^8.7.3\",
                    \"pino\": \"^7.9.2\",
                    \"pino-http\": \"^6.6.0\",
                    \"pino-pretty\": \"^7.6.0\"
                },
                \"devDependencies\": {
                    \"nodemon\": \"^2.0.15\"
                }
            }
                  """),
            new FileBasics("back-end/.gitignore", 
            """
              # dependencies
/node_modules
/.pnp
.pnp.js

# production
/build

# misc
.DS_Store
.env.local
.env.development.local
.env.test.local
.env.production.local
.vercel

npm-debug.log*
yarn-debug.log*
yarn-error.log*
              """), 
              new FileBasics("back-end/README.md", 
              """
                # Dynamic React App Backend

                ## Current Status: Development
                
                 Summary
            """),
            new FileBasics("back-end/knexfile.js", 
              """
                require(\"dotenv\").config();
const path = require(\"path\");

const {
  DATABASE_URL = \"postgres:/\",
  DEBUG,
} = process.env;

module.exports = {
  production: {
    client: \"postgresql\",
    pool: { min: 1, max: 5 },
    connection: DATABASE_URL,
    migrations: {
      directory: path.join(__dirname, \"src\", \"db\", \"migrations\"),
    },
    seeds: {
      directory: path.join(__dirname, \"src\", \"db\", \"seeds\"),
    },
    debug: !!DEBUG,
  },
};
            """),
            new FileBasics("back-end/.env", 
              """
                DATABASE_URL=postgres://
            """),
            new FileBasics("front-end/package.json", 
              """
                {
                  \"name\": \"dynanic-react-app-front-end\",
                  \"version\": \"1.0.0\",
                  \"description\": \"dynamic react app frontend.\",
                  \"main\": \"src/index.js\",
                  \"repository\": {
                      \"type\": \"git\",
                      \"url\": \"https://github.com/MerrixMurphy/dynamic-react-app\",
                      \"directory\": \"/front-end\"
                  },
                  \"private\": true,
                  \"dependencies\": {
                      \"react\": \"^17.0.2\",
                      \"react-dom\": \"^17.0.2\",
                      \"react-router\": \"^6.2.2\",
                      \"react-router-dom\": \"^6.2.2\",
                      \"react-scripts\": \"^5.0.1\",
                      \"web-vitals\": \"^2.1.4\"
                  },
                  \"scripts\": {
                      \"build\": \"react-scripts build\",
                      \"eject\": \"react-scripts eject\",
                      \"start\": \"react-scripts start\"
                  },
                  \"eslintConfig\": {
                      \"extends\": [
                          \"react-app\"
                      ]
                  },
                  \"browserslist\": {
                      \"production\": [
                          \">0.2%\",
                          \"not dead\",
                          \"not op_mini all\"
                      ],
                      \"development\": [
                          \"last 1 chrome version\",
                          \"last 1 firefox version\",
                          \"last 1 safari version\"
                      ]
                  },
                  \"devDependencies\": {
                      \"cross-fetch\": \"^3.1.5\",
                      \"npm-run-all\": \"^4.1.5\"
                  }
              }
            """),
            new FileBasics("front-end/.gitignore", 
              """
                # dependencies
            /node_modules
            /.pnp
            .pnp.js
            
            # production
            /build
            
            # misc
            .DS_Store
            .env.local
            .env.development.local
            .env.test.local
            .env.production.local
            .vercel
            
            npm-debug.log*
            yarn-debug.log*
            yarn-error.log*
            """),
            new FileBasics("front-end/README.md", 
              """
                # Dynamic React App Frontend

                ## Current Status: Development
                
                 Summary
            """),
            new FileBasics("front-end/.env", 
              """
                REACT_APP_API_BASE_URL=http://localhost:5000
            """)
          };

            for(FileBasics f : files){
              FileBasics.fileCreator(path, f.name, f.content);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    private void lvlThree() {
        try {
          Directory dir[] = {
            new Directory("front-end/src/layout"),
            new Directory("front-end/src/utils"),
            new Directory("front-end/src/home"),
            new Directory("back-end/src/db"),
            new Directory("back-end/src/error"),
            new Directory("back-end/src/validation")};

          for(Directory d : dir){
            Directory.dirCreator(path, d.name);
          }

          FileBasics files[] = {
            new FileBasics("front-end/src/App.js","""
              import React from 'react';
            import { Route, Routes } from 'react-router-dom';
            import Layout from \"./layout/layout\";
            
            function App() {
                return (
                    <Routes>
                        <Route path=\"/*\" element={<Layout />} />
                    </Routes>
                );
            }
            
            export default App;
                """),
            new FileBasics("front-end/src/index.js","""
              import React from 'react';
import ReactDOM from 'react-dom';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import App from './App';

ReactDOM.render(
    <React.StrictMode>
        <Router>
            <Routes>
            <Route path=\"/*\" element={<App />}/>
            </Routes>
        </Router>
    </React.StrictMode>,
    document.getElementById('root')
);
              """),
            new FileBasics("front-end/public/index.html","""
              <!DOCTYPE html>
<html lang=\"en\">
  <head>
    <meta charset=\"utf-8\" />
    <meta content=\"width=device-width, initial-scale=1\" name=\"viewport\" />
    <meta content=\"#000000\" name=\"theme-color\" />
    <meta
      content=\"Dynamic React App - Summary.\"
      name=\"description\"
    />
    <link
      href=\"https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,400;0,700;1,700&display=swap\"
      rel=\"stylesheet\"
    />
    <link
      crossorigin=\"anonymous\"
      href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\"
      integrity=\"sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z\"
      rel=\"stylesheet\"
    />
    <link
      crossorigin=\"anonymous\"
      href=\"https://cdnjs.cloudflare.com/ajax/libs/open-iconic/1.1.1/font/css/open-iconic-bootstrap.min.css\"
      integrity=\"sha512-UyNhw5RNpQaCai2EdC+Js0QL4RlVmiq41DkmCJsRV3ZxipG2L0HhTqIf/H9Hp8ez2EnFlkBnjRGJU2stW3Lj+w==\"
      rel=\"stylesheet\"
    />
    <script
      crossorigin=\"anonymous\"
      integrity=\"sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj\"
      src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\"
    ></script>
    <script
      crossorigin=\"anonymous\"
      integrity=\"sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN\"
      src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\"
    ></script>
    <script
      crossorigin=\"anonymous\"
      integrity=\"sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV\"
      src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"
    ></script>
    <title>Dynamic React App</title>
  </head>
  <body>
    <noscript>You need to enable JavaScript to run this app.</noscript>
    <div id=\"root\"></div>
  </body>
</html>
              """),
            new FileBasics("back-end/src/app.js","""
              const path = require(\"path\");

            require(\"dotenv\").config({ path: path.join(__dirname, "..", ".env") });
            
            const express = require(\"express\");
            const cors = require(\"cors\");
            
            const errorHandler = require(\"./error/errorHandler\");
            const notFound = require(\"./error/notFound\");
            
            const dynamicRouter = require(\"./dynamic/dynamic.router\");
            
            const app = express();
            
            app.use(cors());
            app.use(express.json());
            
            app.use(\"/dynamic\", dynamicRouter);
            
            app.use(notFound);
            app.use(errorHandler);
            
            module.exports = app;
              """),
            new FileBasics("back-end/src/server.js","""
              const { PORT = 5000 } = process.env;

const app = require(\"./app\");
const knex = require(\"./db/connection\");

knex.migrate
  .latest()
  .then((migrations) => {
    console.log(\"migrations\", migrations);
    app.listen(PORT, listener);
  })
  .catch((error) => {
    console.error(error);
    knex.destroy();
  });

function listener() {
  console.log(`Listening on Port ${PORT}!`);
}
              """)};

        for(FileBasics f : files){
          FileBasics.fileCreator(path, f.name, f.content);
        }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    private void lvlFour() {
        try{
          Directory dir[] = {
            new Directory("front-end/src/utils/api"),
            new Directory("front-end/src/layout/images"),
            new Directory("/front-end/src/utils/components/"),
            new Directory("./back-end/src/db/migrations"),
            new Directory("./back-end/src/db/seeds")};

          for(Directory d : dir){
            Directory.dirCreator(path, d.name);
          }

          FileBasics files[] = {
            new FileBasics("front-end/src/home/Home.js","""
              import React from \"react\";
        import { Link } from \"react-router-dom\";
        
        function Home() {
        
          return (
            <main className=\"text-center\">
              <h1 className=\"clearmargin\">Home</h1>
            </main>
          );
        }
        
        export default Home;
                """),
            new FileBasics("front-end/src/layout/layout.css","""
              @import url(\"https://fonts.googleapis.com/css2?family=Anton&display=swap\");

a {
  display: inline-block;
  font-weight: 500;
  font-size: 16px;
  color: black;
  text-decoration: none;
  font-family: \"Anton\", sans-serif;
}
header {
  display: flex;
  flex-direction: column;
  align-items: center;
  background-color: #ff0000;
}
.navMenu {
  border-bottom: 2px black solid;
}
nav {
  width: 100%;
  text-align: center;
}
.selected {
  background-color: #c40000;
}
.navMenu:hover {
  background-color: #c40000;
}

img {
  height: 105px;
}

footer {
  background-color: rgb(54, 54, 54);
  display: flex;
}

#page-container {
  position: relative;
  min-height: 100vh;
}

#content-wrap {
  padding-bottom: 2.5rem;
}

#footer {
  display: flex;
  flex-direction: row;
  justify-content: space-evenly;
  position: absolute;
  bottom: 0;
  width: 100%;
  height: 70px;
}

.footerImg {
  padding-top: 10px;
  height: 50px;
  width: 50px;
}

@media only screen and (min-width: 800px) {
  nav {
    display: flex;
    justify-content: space-between;
    height: 108px;
    border: 2px black solid;
  }
  .row {
    display: flex;
    flex-direction: row;
  }
  .navMenu {
    display: flex;
    align-items: center;
    border-bottom: 0px black solid;
    border-left: 2px black solid;
  }
  .spacing {
    padding: 0px 15px 0px 15px;
  }
}
                """),
            new FileBasics("front-end/src/layout/layout.js","""
              import React from \"react\";
              import Nav from \"./nav\";
              import Routing from \"./routes\";
              import Footer from \"./footer\";
              
              import \"./layout.css\";
              
              function Layout() {
                return (
                  <div>
                    <Nav />
                    <Routing />
                    <Footer />
                    </div>
                );
              }
              
              export default Layout;
                """),
            new FileBasics("front-end/src/layout/routes.js","""
              import React from 'react';
import { Navigate, Route, Routes } from \"react-router-dom\";

import Home from '../home/home';
import NotFound from \"./notFound\";

function Routing() {
  return (
    <Routes>
      <Route exact={true} path=\"/\" element={<Navigate to={\"/home\"} />} />
      <Route path=\"/home\" element={<Home />} />
      <Route element={<NotFound />} />
    </Routes>
  );
}

export default Routing;
                """),
            new FileBasics("front-end/src/layout/notFound.js","""
              import React from 'react';

function NotFound() {
    return (
        <main className=\"text-center\">
        <div className=\"NotFound\">
            <h1>404</h1>
            <h2>Page not found</h2>
        </div>
        </main>
    );
}

export default NotFound;
                """),
            new FileBasics("front-end/src/layout/nav.js","""
              import React from 'react';
import { Link } from 'react-router-dom';

function nav() {
    return (
        <nav >
<div >
        <ul>
          <li >
            <Link to=\"/dynamic\">
              <span  />
              &nbsp;Dynamic
            </Link>
          </li>
        </ul>
      </div>
    </nav>
  );
}

export default nav
                """),
            new FileBasics("front-end/src/layout/footer.js","""
              import React from 'react'
import { Link } from 'react-router-dom';

function footer() {
    return (
        <footer id=\"footer\">
                    <div><a href=\"https://dynamic\" target=\"blank\"><img className='footerImg' src={require('./images/dynamic.png')} alt=\"dynamic\"/></a></div>
        </footer>
  )
}

export default footer
                """),
            new FileBasics("back-end/src/validation/validations.js","""
              module.exports = {
              }
                """),
            new FileBasics("back-end/src/error/asyncErrorBoundary.js","""
              function asyncErrorBoundary(delegate, defaultStatus) {
                return (request, response, next) => {
                  Promise.resolve()
                    .then(() => delegate(request, response, next))
                    .catch((error = {}) => {
                      const { status = defaultStatus, message = error } = error;
                      next({
                        status,
                        message,
                      });
                    });
                };
              }
              
              module.exports = asyncErrorBoundary;
                """),
            new FileBasics("back-end/src/error/errorHandler.js","""
              function errorHandler(error, request, response, next) {
                const { status = 500, message = \"Something went wrong!\" } = error;
                response.status(status).json({ error: message });
              }
              
              module.exports = errorHandler;
                """),
            new FileBasics("back-end/src/error/methodNotAllowed.js","""
              function methodNotAllowed(req, res, next) {
                next({
                  status: 405,
                  message: `${req.method} not allowed for ${req.originalUrl}`,
                });
              }
              
              module.exports = methodNotAllowed;
                """),
            new FileBasics("back-end/src/error/notFound.js","""
              function notFound(req, res, next) {
                next({ status: 404, message: `Path not found: ${req.originalUrl}` });
              }
              
              module.exports = notFound;
                """),
            new FileBasics("back-end/src/db/connection.js","""
              const environment = process.env.NODE_ENV || \"development\";
const config = require(\"../../knexfile\")[environment];
const knex = require(\"knex\")(config);

module.exports = knex;
                """)};
      
                for(FileBasics f : files){
                  FileBasics.fileCreator(path, f.name, f.content);
                }
    } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    private void lvlFive() {
        try{

            FileBasics[] files = {
            new FileBasics("front-end/src/utils/api/api.js","""
              const API_BASE_URL = 
      process.env.REACT_APP_API_BASE_URL || \"http://localhost:5000\";

const headers = new Headers();
headers.append(\"Content-Type\", \"application/json\");
                """),
            new FileBasics("back-end/src/db/seeds/jsonCreator.js","""
              import fetch from \"node-fetch\";
import fs from \"fs\";
/*
Dynamic Summary
*/
const externalAPIs = [
  {
    apiName: \"dynamic\",
    urlName:
      \"https://dynamic\",
    requestSpec: {},
  },
];

const seeder = async () => {
  return externalAPIs.forEach(async (url) => {
    let ingData = null;
    return await fetch(url.urlName, {
      headers: url.requestSpec,
      method: \"GET\",
    })
      .then((res) => res.json())
      .then((res) => {
        if (Array.isArray(res)) {
          return res;
        } else {
          const firstKey = Object.values(res)[0];
          return firstKey;
        }
      })
      .then((res) => {
        const listedData = [];
        res.forEach((data) => {
          switch (Object.keys(data)[0]) {
            case \"dynamic\":
              listedData.push({
                dynamic: data.dynamic,
              });
              break;
            default:
              console.log(`Sorry no dynamic found for ${data}`);
          }
        });
        return listedData;
      })
      .then((res) => (ingData = JSON.stringify(res)))
      .then(() =>
        fs.writeFile(`data${url.apiName}.json`, ingData, (err) =>
          err ? console.log : null
        )
      );
  });
};

seeder();
                """)};
      
              for(FileBasics f : files){
                FileBasics.fileCreator(path, f.name, f.content);
              }
} catch (Exception e) {
    System.out.println("Error: " + e);
    }
}

    public void treeBuilder(String url) {
        try{
            path = url;
            lvlOne();
            lvlTwo();
            lvlThree();
            lvlFour();
            lvlFive();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
}

public void addComponent(String url){
  try{
    path = url;
    FileBasics[] files = {
      new FileBasics("front-end/src/utils/components/component.js","""
        function form(props) {
          return \"check\"
      }
      
      export default form;
          """)};
          for(FileBasics f : files){
            FileBasics.fileCreator(path, f.name, f.content);
          }
  } catch (Exception e) {
    System.out.println("Error: " + e);
  }
}
}
