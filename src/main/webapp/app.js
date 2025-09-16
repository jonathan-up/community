import liveServer from 'live-server'

var params = {
    port: 8181, // Set the server port. Defaults to 8080.
    host: "0.0.0.0", // Set the address to bind to. Defaults to 0.0.0.0 or process.env.IP.
    root: "./", // Set root directory that's being served. Defaults to cwd.
    open: false, // When false, it won't load your browser by default.
    file: "index.html", // When set, serve this file (server root relative) for every 404 (useful for single-page applications)
    wait: 0, // Waits for all changes, before reloading. Defaults to 0 sec.
    // mount: [['/components', './node_modules']], // Mount a directory to a route.
    logLevel: 2, // 0 = errors only, 1 = some, 2 = lots
    middleware: [
        function (req, res, next) {
            next();
        }
    ],
    proxy: [
        ['/api', 'http://127.0.0.1:8080/api'], // 代理规则：将 /api 转发到后端
        ['/upload', 'http://127.0.0.1:8080/upload'] // 代理规则：将 /upload 转发到后端
    ]
};
liveServer.start(params);