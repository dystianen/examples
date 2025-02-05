import { Hono } from 'hono'
import user_router from './routes/user_router';
import { logger } from './pkg/log/main';

const app = new Hono()

app.get('/', (c) => c.text('Hello, Hono!'))
app.get('/test-logs', (c) => {
    logger.info('Log info')
    logger.error('Log error')
    return c.text('Hello, Hono!')
})
app.route('/user', user_router)

export default {
  port: 8000,
  fetch: app.fetch,
};