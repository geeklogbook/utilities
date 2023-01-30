"""
Using the python log subsystem
"""

import logging

logging.basicConfig(filename='example.log', encoding='utf-8', level=logging.DEBUG)
logging.warning("Ey, this is a logging warning")
logging.error("Ey, this is a logging error")
logging.debug('This message should go to the log file')
logging.info('So should this')
logging.warning('And this, too')
logging.error('And non-ASCII stuff, too, like Øresund and Malmö')
