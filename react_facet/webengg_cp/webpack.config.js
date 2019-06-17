const path = require('path');
const webpack = require('webpack');
const HtmlWebpackPlugin = require('html-webpack-plugin');
module.exports = (env, options) => {
    const file_name = '';
	const devtool_val = options.mode == 'development' ? 'source-map' : '';
    const output_dir = path.resolve(__dirname, 'dist') ;
    return {
        // context: __dirname,
        entry: {main: './src/' + file_name},
        output: {
            path: output_dir,
            filename:  file_name
        },
        devtool: devtool_val,
        module: {
            rules: [{
                test: /\.css$/,
                use: ['style-loader', {
                    loader: 'css-loader',
                    // options: {
                    //     // Minify css
                    //     minimize: true
                    // }
                }]
            }, {
                test: /\.(png|gif|jpg|jpeg|svg|xml|json)$/,
                use: ['url-loader']
            }, {
                // Remove pragmas
                test: /\.js$/,
                // enforce: 'pre',
                exclude: /node_modules/,
                // include: path.resolve(__dirname, cesiumSource),
                use: {loader: "babel-loader"}
            }]
        },
        plugins: [
            new HtmlWebpackPlugin({
                template: 'src/index.html'
            }),
        ],

    }
};
