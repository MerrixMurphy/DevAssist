import java.io.File;
import java.io.FileWriter;

public class BasicReact {
    String path;
    
    private void lvlOne() {
        try{
        new File(path + "front-end").mkdir();
        new File(path + "back-end").mkdir();
        FileWriter gitignore = new FileWriter (path + ".gitignore");
        gitignore.write("""
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
                """);
        gitignore.close();
        FileWriter readme = new FileWriter (path + "README.md");
        readme.write("""
            # Dynamic React App

            ## Current Status: Development
            
             Summary
                """);
        readme.close();
        FileWriter packagejson = new FileWriter (path + "package.json");
        packagejson.write("""
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
        """);
        packagejson.close();
          } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    private void lvlTwo() {
        try {
            new File(path + "front-end/src").mkdir();
            new File(path + "front-end/public").mkdir();
            new File(path + "back-end/src").mkdir();
            FileWriter back_packagejson = new FileWriter (path + "back-end/package.json");
            back_packagejson.write("""
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

        """);
        back_packagejson.close();
        FileWriter back_gitignore = new FileWriter (path + "back-end/.gitignore");
        back_gitignore.write("""
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
                """);
                back_gitignore.close();
        FileWriter back_readme = new FileWriter (path + "back-end/README.md");
        back_readme.write("""
            # Dynamic React App Backend

            ## Current Status: Development
            
             Summary
                """);
                back_readme.close();
        FileWriter back_knexfile = new FileWriter (path + "back-end/knexfile.js");
        back_knexfile.write("""
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
                    """);
                    back_knexfile.close();
        FileWriter back_env = new FileWriter (path + "back-end/.env");
        back_env.write("""
            DATABASE_URL=postgres://
            """);
            back_env.close();
            FileWriter front_packagejson = new FileWriter (path + "back-end/package.json");
            front_packagejson.write("""
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
        """);
        front_packagejson.close();
        FileWriter front_gitignore = new FileWriter (path + "back-end/.gitignore");
        front_gitignore.write("""
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
                """);
                front_gitignore.close();
        FileWriter front_readme = new FileWriter (path + "back-end/README.md");
        front_readme.write("""
            # Dynamic React App Frontend

            ## Current Status: Development
            
             Summary
                """);
                front_readme.close();
        FileWriter front_env = new FileWriter (path + "back-end/.env");
        front_env.write("""
            REACT_APP_API_BASE_URL=http://localhost:5000
            """);
            front_env.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    private void lvlThree() {
        try {
            new File(path + "front-end/src/layout").mkdir();
            new File(path + "front-end/src/utils").mkdir();
            new File(path + "front-end/src/home").mkdir();
            new File(path + "back-end/src/db").mkdir();
            new File(path + "back-end/src/error").mkdir();
            new File(path + "back-end/src/validation").mkdir();
            FileWriter front_app = new FileWriter (path + "front-end/src/App.js");
            front_app.write("""
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
            """);
            front_app.close();
            FileWriter front_index = new FileWriter (path + "front-end/src/index.js");
            front_index.write("""
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
""");
front_index.close();
FileWriter front_html = new FileWriter (path + "front-end/public/index.html");
front_html.write("""
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
        """);
        front_html.close();
        FileWriter back_app = new FileWriter (path + "back-end/src/app.js");
        back_app.write("""
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
                """);
        back_app.close();
        FileWriter back_server = new FileWriter (path + "back-end/src/server.js");
        back_server.write("""
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
                """);
        back_server.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    private void lvlFour() {
        try{
        new File(path + "front-end/src/utils/api").mkdir();
        new File(path + "front-end/src/layout/images").mkdir();
        new File(path + "/front-end/src/components/").mkdir();
        new File(path + "./back-end/src/db/migrations").mkdir();
        new File(path + "./back-end/src/db/seeds").mkdir();
    FileWriter home = new FileWriter (path + "front-end/src/home/Home.js");
    home.write("""
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
            """);
    home.close();
    FileWriter css = new FileWriter (path + "front-end/src/layout/layout.css");
    css.write("""
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
            """);
    css.close();
    FileWriter layout = new FileWriter (path + "front-end/src/layout/layout.js");
    layout.write("""
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
            """);
            layout.close();
    FileWriter routes = new FileWriter (path + "front-end/src/layout/routes.js");
    routes.write("""
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
            """);
            routes.close();
    FileWriter front_notFound = new FileWriter (path + "front-end/src/layout/notFound.js");
    front_notFound.write("""
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
            """);
            front_notFound.close();
    FileWriter nav = new FileWriter (path + "front-end/src/layout/nav.js");
    nav.write("""
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
            """);
            nav.close();
    FileWriter footer = new FileWriter (path + "front-end/src/layout/footer.js");
    footer.write("""
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
            """);
            footer.close();
    FileWriter validations = new FileWriter (path + "back-end/src/validation/validations.js");
    validations.write("""
module.exports = {
}
                """);
                validations.close();
            FileWriter asyncErrorBoundary = new FileWriter (path + "back-end/src/error/asyncErrorBoundary.js");
            asyncErrorBoundary.write("""
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
                """);
                asyncErrorBoundary.close();
            FileWriter errorHandler = new FileWriter (path + "back-end/src/error/errorHandler.js");
            errorHandler.write("""
                function errorHandler(error, request, response, next) {
                    const { status = 500, message = \"Something went wrong!\" } = error;
                    response.status(status).json({ error: message });
                  }
                  
                  module.exports = errorHandler;
                """);
                errorHandler.close();
            FileWriter methodNotAllowed = new FileWriter (path + "back-end/src/error/methodNotAllowed.js");
            methodNotAllowed.write("""
                function methodNotAllowed(req, res, next) {
                    next({
                      status: 405,
                      message: `${req.method} not allowed for ${req.originalUrl}`,
                    });
                  }
                  
                  module.exports = methodNotAllowed;
                """);
                methodNotAllowed.close();
            FileWriter back_notFound = new FileWriter (path + "back-end/src/error/notFound.js");
            back_notFound.write("""
                function notFound(req, res, next) {
                    next({ status: 404, message: `Path not found: ${req.originalUrl}` });
                  }
                  
                  module.exports = notFound;
                """);
                back_notFound.close();
            FileWriter connection = new FileWriter (path + "back-end/src/db/connection.js");
            connection.write("""
                const environment = process.env.NODE_ENV || \"development\";
const config = require(\"../../knexfile\")[environment];
const knex = require(\"knex\")(config);

module.exports = knex;
                """);
                connection.close();
    } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    private void lvlFive() {
        try{
        FileWriter api = new FileWriter (path + "front-end/src/utils/api/api.js");
    api.write("""
        const API_BASE_URL = 
      process.env.REACT_APP_API_BASE_URL || \"http://localhost:5000\";

const headers = new Headers();
headers.append(\"Content-Type\", \"application/json\");
                """);
    api.close();
    FileWriter jsonCreator = new FileWriter (path + "back-end/src/db/seeds/jsonCreator.js");
    jsonCreator.write("""
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
              """);
              jsonCreator.close();
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
}
