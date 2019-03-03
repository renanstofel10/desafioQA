'use strict';
const request = require('supertest');
const joiAssert = require('joi-assert');
const parameters = require('./parameters.json');
const URL = 'http://www.omdbapi.com';
var PATH;

describe('Desafio 2 - Noesis', function () {
  it('Validando título, ano e linguagem de filme', function (done) {
    PATH = `/?i=${parameters.ID_DO_FILME}&apikey=${parameters.API_KEY}`;
    request(URL)
    .get(PATH)
    .expect('Content-Type', /json/)
    .end(function (err, res) {
      joiAssert(res.status, 200);
      joiAssert(res.body.Response, true)
      joiAssert(res.body.Title, 'The Social Network');
      joiAssert(res.body.Year, 2010);
      joiAssert(res.body.Language, 'English, French');
      done(err);
    })
  });

  it('Validando busca de filme inexistente', function (done) {
    PATH = `/?i=${parameters.ID_INVALID}&apikey=${parameters.API_KEY}`;
    request(URL)
    .get(PATH)
    .expect('Content-Type', /json/)
    .end(function (err, res) {
      joiAssert(res.status, 200);
      joiAssert(res.body.Response, false)
      joiAssert(res.body.Error, 'Incorrect IMDb ID.')
      done(err);
    })
  });
});